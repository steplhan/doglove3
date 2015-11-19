package pe.edu.softwareii.doglove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import pe.edu.softwareii.doglove.login.LoginRetrofitPresenter;
import pe.edu.softwareii.doglove.login.LoginView;
import pe.edu.softwareii.doglove.model.dto.Mascota;
import pe.edu.softwareii.doglove.model.dto.Usuario;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {
    Button butLogin;
    EditText eteUsername, etePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        butLogin = (Button)findViewById(R.id.butLogin);
        //ButLoginFacebook = (Button)findViewById(R.id.butLoginFacebook);
        //butRegistrar = (Button)findViewById(R.id.butRegistrar);
        eteUsername = (EditText)findViewById(R.id.eteUsername);
        etePassword = (EditText)findViewById(R.id.etePassword);

        butLogin.setOnClickListener(this);
        //ButLoginFacebook.setOnClickListener(this);
        //butRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.butLogin) {
            String nombre = eteUsername.getText().toString();
            String password = etePassword.getText().toString();

            //Con login FB
            String apellidop="Marmol";
            String apellidom="Picapiedra";
            String email="holahola@gmail.com";


            //new LoginPresenter(this).login(username, password);
            new LoginRetrofitPresenter(this).login(nombre,apellidop,apellidom, email);



        }/*else if (view.getId() == R.id.butLoginFacebook){
            Log.i("MainActivity", "Se hizo click en el boton LoginFacebook");
            Toast.makeText(
                    this,
                    "Opcion de LoginFacebook... proximamente",
                    Toast.LENGTH_LONG
            ).show();
        }*/
    }

    @Override
    public void onLoginCorrecto(Usuario mUsuario,List<Mascota> mascotas) {

        //ApplicationController.getApplicationController(new Mascota(),new Usuario()).setmUsuario(mUsuario);

        Intent intent = new Intent();
        if (mascotas.isEmpty()) {
            intent.setClass(LoginActivity.this, RegistrarMascotaActivity.class);

        }else {
            intent.setClass(LoginActivity.this, HomeActivity.class);
            Toast.makeText(this, "Mascota 1: " + mascotas.get(0).getNombreMascota() + mascotas.get(0).getRaza(), Toast.LENGTH_LONG);
            //intent.putExtra("mascota", mascotas.get(0));
            ApplicationController.getApplicationController().setmMascota(mascotas.get(0));
        }
        //intent.putExtra("usuario", mUsuario);
        ApplicationController.getApplicationController().setmUsuario(mUsuario);
        startActivity(intent);
    }

    @Override
    public void onLoginIncorrecto() {
        // Mostrar un toast de error
        Toast.makeText(
                this,
                "Error en login",
                Toast.LENGTH_SHORT
        ).show();
        // Limpiar los edittext
        eteUsername.setText("");
        etePassword.setText("");
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(
                this,
                "EXC: " + msg,
                Toast.LENGTH_LONG
        ).show();
    }



}


