package pe.edu.softwareii.doglove.registrarmascota;

/**
 * Created by JORGE on 06/10/2015.
 */
public interface RegistroMascotaView {
    public void onRegistroCorrecto();
    public void onRegistroIncorrecto();
    public void onError(String msg);
}
