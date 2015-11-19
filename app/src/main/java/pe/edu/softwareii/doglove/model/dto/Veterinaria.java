package pe.edu.softwareii.doglove.model.dto;

/**
 * Created by JORGE on 09/11/2015.
 */
public class Veterinaria {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String logo;

    public Veterinaria(){}

    public Veterinaria(String nombre, int id, String direccion, String telefono, String logo) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
