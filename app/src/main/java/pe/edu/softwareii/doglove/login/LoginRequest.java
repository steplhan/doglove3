package pe.edu.softwareii.doglove.login;

/**
 * Created by hquintana on 12/09/15.
 */
public class LoginRequest {


    private String nombre;
    private String apellidop;
    private String apellidom;
    private String email;

    public LoginRequest( String nombre, String apellidop, String apellidom, String email) {

        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.email = email;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
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
}
