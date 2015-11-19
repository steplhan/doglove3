package pe.edu.softwareii.doglove.registrarmascota;

/**
 * Created by JORGE on 06/10/2015.
 */
public class RegistrarMacotaResponse {
    private String msgStatus;
    private String msgError;


    public RegistrarMacotaResponse() {
    }

    public RegistrarMacotaResponse(String msgStatus, String msgError) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;

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


}
