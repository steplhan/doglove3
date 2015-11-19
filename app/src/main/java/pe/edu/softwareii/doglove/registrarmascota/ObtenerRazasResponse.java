package pe.edu.softwareii.doglove.registrarmascota;

import java.util.List;

import pe.edu.softwareii.doglove.model.dto.Raza;

public class ObtenerRazasResponse {
    private String msgStatus;
    private String msgError;
    private List<Raza> razas;

    public ObtenerRazasResponse() {
    }

    public ObtenerRazasResponse(String msgStatus, String msgError, List<Raza> razas) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
        this.razas = razas;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public List<Raza> getRazas() {
        return razas;
    }

    public void setRazas(List<Raza> razas) {
        this.razas = razas;
    }
}
