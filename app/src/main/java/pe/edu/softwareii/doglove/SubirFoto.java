package pe.edu.softwareii.doglove;

import android.os.AsyncTask;
import android.util.Log;

import com.cloudinary.Cloudinary;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pe.edu.softwareii.doglove.model.dto.Mascota;
import pe.edu.softwareii.doglove.registrarmascota.RegistrarMascotaRetrofitPresenter;
import pe.edu.softwareii.doglove.registrarmascota.RegistroMascotaView;

/**
 * Created by JORGE on 12/11/2015.
 */
public class SubirFoto extends AsyncTask {
    //private byte[] imagen;
    private File imagen;
    private RegistroMascotaView view;
    private String nombre;
    private String genero;
    private String fecha;
    private int id_raza;

    public SubirFoto(File imagen, RegistroMascotaView view, String nombre,String genero, String fecha, int id_raza){
        this.imagen=imagen;
        this.view = view;
        this.nombre=nombre;
        this.genero=genero;
        this.fecha=fecha;
        this.id_raza=id_raza;
    }
    @Override
    protected Object doInBackground(Object[] objects) {

        Map config = new HashMap();
        config.put("cloud_name", "ddvisvduf");
        config.put("api_key", "522733418747999");
        config.put("api_secret", "U9AdB6fDJIps3V7sGYfhbow4ZOw");
        Cloudinary cloudinary = new Cloudinary(config);


        String urlFoto="";
        try {

            Map uploadResult = cloudinary.uploader().upload(imagen, null);
            urlFoto = (String)uploadResult.get("url");
            Log.i("etiqueta",urlFoto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlFoto;
    }

    @Override
    protected void onPostExecute(Object o) {
        Mascota mascota=new Mascota(nombre,o.toString(),genero,fecha,id_raza);

        ApplicationController.getApplicationController().setmMascota(mascota);
        view.onRegistroCorrecto();

        //Llamado al retrofit
        new RegistrarMascotaRetrofitPresenter(view).registrarMascota(mascota);

    }
}
