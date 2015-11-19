package pe.edu.softwareii.doglove.model.dto;

/**
 * Created by JORGE on 26/10/2015.
 */
public class Raza {
    private int id_raza;
    private String nombre;

    public Raza(String nombre, int id_raza) {
        this.nombre = nombre;
        this.id_raza = id_raza;
    }

    public int getId_raza() {
        return id_raza;
    }

    public void setId_raza(int id_raza) {
        this.id_raza = id_raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
