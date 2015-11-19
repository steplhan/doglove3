package pe.edu.softwareii.doglove.login;

import java.util.List;

import pe.edu.softwareii.doglove.model.dto.Mascota;
import pe.edu.softwareii.doglove.model.dto.Usuario;

/**
 * Created by hquintana on 12/09/15.
 */
public interface LoginView {
    public void onLoginCorrecto(Usuario mUsuario,List<Mascota> mascotas);
    public void onLoginIncorrecto();
    public void onError(String msg);

}
