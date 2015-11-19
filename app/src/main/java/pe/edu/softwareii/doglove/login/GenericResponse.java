package pe.edu.softwareii.doglove.login;

import java.util.List;

import pe.edu.softwareii.doglove.model.dto.Mascota;
import pe.edu.softwareii.doglove.model.dto.Usuario;

/**
 * Created by hquintana on 12/09/15.
 */
public class GenericResponse {
    private String msgStatus;
    private String msgError;
    private Usuario usuario;
    private List<Mascota> mascotas;
    //private Mascota[] mascotas;

    /*public GenericResponse(String msgStatus, String msgError, Usuario usuario, Mascota[] mascotas) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
        this.usuario = usuario;
        this.mascotas = mascotas;
    }*/

    public GenericResponse(String msgStatus, String msgError, Usuario usuario, List<Mascota> mascotas) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
        this.usuario = usuario;
        this.mascotas = mascotas;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /*public Mascota[] getMascotas() {
        return mascotas;
    }

    public void setMascotas(Mascota[] mascotas) {
        this.mascotas = mascotas;
    }*/

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
