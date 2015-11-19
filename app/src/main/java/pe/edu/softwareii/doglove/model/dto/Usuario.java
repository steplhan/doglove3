package pe.edu.softwareii.doglove.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable{
    private long id;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private String email;
    private List<Mascota> listaMascotas;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidop, String apellidom, String email) {
        this.id = 0;
        this.nombre = nombre;
        this.apellidom = apellidom;
        this.email = email;
        this.apellidop = apellidop;
        this.listaMascotas=new ArrayList<Mascota>();
    }

    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(List<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }
}
