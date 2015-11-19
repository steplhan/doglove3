package pe.edu.softwareii.doglove.veterinarias;

import java.util.List;

import pe.edu.softwareii.doglove.model.dto.Veterinaria;

/**
 * Created by JORGE on 09/11/2015.
 */
public class ObtenerVeterinariasResponse {
    private String msgStatus;
    private String msgError;
    private List<Veterinaria> veterinarias;

    public ObtenerVeterinariasResponse(){}

    public ObtenerVeterinariasResponse(String msgStatus, String msgError, List<Veterinaria> veterinarias) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
        this.veterinarias = veterinarias;
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

    public List<Veterinaria> getVeterinarias() {
        return veterinarias;
    }

    public void setVeterinarias(List<Veterinaria> veterinarias) {
        this.veterinarias = veterinarias;
    }
}
