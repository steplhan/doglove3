package pe.edu.softwareii.doglove.inicio;

import java.util.List;

import pe.edu.softwareii.doglove.model.dto.Mascota;

/**
 * Created by JORGE on 02/11/2015.
 */
public class PosiblesMatchesResponse {
    private String msgStatus;
    private String msgError;
    private List<Mascota> mascotas;

    public PosiblesMatchesResponse() {
    }

    public PosiblesMatchesResponse(String msgStatus, String msgError, List<Mascota> mascotas) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
        this.mascotas = mascotas;
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

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
