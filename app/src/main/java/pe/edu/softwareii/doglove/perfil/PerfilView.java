package pe.edu.softwareii.doglove.perfil;

import pe.edu.softwareii.doglove.model.dto.Mascota;

/**
 * Created by JORGE on 06/10/2015.
 */
public interface PerfilView {
    public void onPerfilLoaded(Mascota mascota);
    public void onError(String error);
}
