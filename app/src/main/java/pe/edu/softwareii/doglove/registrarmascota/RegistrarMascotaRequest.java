package pe.edu.softwareii.doglove.registrarmascota;


import pe.edu.softwareii.doglove.ApplicationController;

public class RegistrarMascotaRequest {

    private String nombre;
    private String foto;
    private String genero;
    private int id_raza;
    private String fecha_nacimiento;
    private int id_usuario;

    public RegistrarMascotaRequest( String nombre,String foto, int id_raza, String genero, String fecha) {

        this.nombre = nombre;
        this.foto=foto;
        this.id_raza = id_raza;
        this.genero = genero;
        this.fecha_nacimiento = fecha;
        this.id_usuario= (int)ApplicationController.getApplicationController().getmUsuario().getId();
    }

    public RegistrarMascotaRequest() {
    }



    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_raza() {
        return id_raza;
    }

    public void setId_raza(int id_raza) {
        this.id_raza = id_raza;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
