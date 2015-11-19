package pe.edu.softwareii.doglove;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;

import pe.edu.softwareii.doglove.model.dto.Raza;
import pe.edu.softwareii.doglove.model.dto.Usuario;
import pe.edu.softwareii.doglove.registrarmascota.RegistroMascotaView;

public class RegistrarMascotaActivity extends AppCompatActivity implements View.OnClickListener, RegistroMascotaView{


    private static final String url = "http://dev03.presla.co";

    Raza[] razas=null;
    //String[] nombreRazas=null;
    String[] nombreRazas={"Elige una raza","bull dog","labrador","bull terrier"};
    EditText eteNombre;
    Spinner spiRaza;
    RadioGroup rgrGenero;
    RadioButton rbuMacho, rbuHembra;
    DatePicker dpiFecha;
    Button butRegistroMascota;
    Usuario usuario;
    ImageView iviFoto;
    Uri foto=null;
    private String mFotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_mascota);

        //Usuario usuario=ApplicationController.getApplicationController(new Mascota(),new Usuario()).getmUsuario();
        usuario=ApplicationController.getApplicationController().getmUsuario();
        Toast.makeText(this,usuario.getNombre()+" "+ usuario.getApellidop()+ " "+usuario.getApellidom(),Toast.LENGTH_LONG).show();

        eteNombre=(EditText)findViewById(R.id.eteNombre);
        rgrGenero=(RadioGroup)findViewById(R.id.rgrGenero);
        dpiFecha=(DatePicker)findViewById(R.id.dpiFecha);
        spiRaza=(Spinner)findViewById(R.id.spiRaza);
        butRegistroMascota=(Button)findViewById(R.id.butRegistroMascota);
        rbuMacho=(RadioButton)findViewById(R.id.rbuMacho);
        rbuHembra=(RadioButton)findViewById(R.id.rbuHembra);
        iviFoto=(ImageView)findViewById(R.id.iviAddFoto);

        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DogloveService service = retrofit.create(DogloveService.class );

        service.obtenerRazas().enqueue(new Callback<ObtenerRazasResponse>() {
            @Override
            public void onResponse(Response<ObtenerRazasResponse> response, Retrofit retrofit) {

                if (response.body().getMsgStatus().equals("OK")) {
                    razas = (Raza[]) response.body().getRazas().toArray();
                    nombreRazas[0] = "Seleccione la raza";
                    for (int i = 0; i < razas.length; i++) {
                        nombreRazas[i + 1] = razas[i].getNombre();
                    }

                } else {
                    onCargarRazasIncorrecto();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }


        });*/


        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nombreRazas);


        spiRaza.setAdapter(adapter);

        spiRaza.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        iviFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent.createChooser(intent, "Select image"), 1);

            }
        });
        butRegistroMascota.setOnClickListener(this);

    }

    /*private String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(this, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK){
            if(requestCode==1){
                foto=data.getData();
                iviFoto.setImageURI(foto);
            }
        }
    }



    public void onCargarRazasIncorrecto(){
        Toast.makeText(this,"Error al cargar mascotas",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.butRegistroMascota){

            //byte[] imagen=null;
            File imagen=null;
            //imagen= Files.toByteArray(new File(foto.getPath()));
            imagen=new File(foto.getPath());

            //Picasso.with(this).load(foto.getPath()).resize(targetW, targetH).centerCrop().into(iviFoto);
            String nombre=eteNombre.getText().toString();
            String genero="";

            if(rgrGenero.getCheckedRadioButtonId()==R.id.rbuMacho){
                genero="M";
            }else if(rgrGenero.getCheckedRadioButtonId()==R.id.rbuHembra){
                genero="F";
            }

            String fecha=dpiFecha.getMonth()+"-"+dpiFecha.getDayOfMonth()+"-"+dpiFecha.getYear();
            int id_raza=spiRaza.getSelectedItemPosition();
            //int id_raza=razas[spiRaza.getSelectedItemPosition()-1].getId_raza();

            if(!nombre.equals("") && !genero.equals("") && spiRaza.getSelectedItemPosition()!=0 ){

                (new SubirFoto(imagen,this,nombre,genero,fecha,id_raza)).execute(null);





            }


        }
    }

    @Override
    public void onRegistroCorrecto() {
        //ApplicationController.getApplicationController(new Mascota(),new Usuario()).setmMascota(mMascota);
        Intent intent = new Intent();
        intent.setClass(RegistrarMascotaActivity.this,
                HomeActivity.class);

        //intent.putExtra("mascota", ApplicationController.getApplicationController().getmMascota());
        //intent.putExtra("usuario",usuario);
        startActivity(intent);
    }

    @Override
    public void onRegistroIncorrecto() {

    }

    @Override
    public void onError(String msg) {

    }
}

