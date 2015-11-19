package pe.edu.softwareii.doglove.model.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by JORGE on 04/10/2015.
 */
public class Mascota implements Serializable{

    private int id_mascota;
    private String nombre;
    private String urlFoto;
    private String descripcion;
    private String genero;
    private String fecha;
    private int id_raza;
    private int id_usuario;


    public Mascota(){

    };

    public Mascota(String nombre,String foto, String genero, String fechaNac, int raza) {
        this.id_mascota= 0;
        this.nombre = nombre;
        this.urlFoto=foto;
        this.descripcion = "Escribe algo sobre tu mascota";
        this.genero = genero;
        this.fecha = fechaNac;
        this.id_raza = raza;
    }

    public int getIdMascota() {
        return id_mascota;
    }

    public void setIdMascota(int idMascota) {
        this.id_mascota = idMascota;
    }

    public String getNombreMascota() {
        return nombre;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombre = nombreMascota;
    }

    public String getFoto() {
        return urlFoto;
    }

    public void setFoto(String foto) {
        this.urlFoto = foto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNac() {
        return fecha;
    }

    public void setFechaNac(String fechaNac) {
        this.fecha = fechaNac;
    }

    public int getRaza() {
        return id_raza;
    }

    public void setRaza(int raza) {
        this.id_raza = raza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdad(){
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("MM-DD-YYYY");

        try {
            return (int)((calendar.getTime().getTime()-formatoFecha.parse(getFechaNac()).getTime())/(365*24*60*60))/1000;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
