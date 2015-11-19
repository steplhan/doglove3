package pe.edu.softwareii.doglove;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

public class ContenedorActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    NavigationView navigation;
    DrawerLayout dlaContenedor;
    Toolbar toolbar;
    TabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);

        navigation = (NavigationView) findViewById(R.id.navigation);
        dlaContenedor = (DrawerLayout) findViewById(R.id.dlaContenedor);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabHost=(TabHost) findViewById(R.id.tabHost);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlaContenedor.openDrawer(GravityCompat.START);
            }
        });




        navigation.setNavigationItemSelectedListener(this);
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Intent intent=new Intent();
        switch(menuItem.getItemId()){
            case R.id.menVeterinarias:


                intent.setClass(ContenedorActivity.this, VeterinariasActivity.class);
                startActivity(intent);
                return true;
            case R.id.menEditarPerfil:

                intent.setClass(ContenedorActivity.this, VeterinariasActivity.class);
                return true;

        }

        return false;
    }



}
