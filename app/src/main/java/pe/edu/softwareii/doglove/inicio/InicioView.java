package pe.edu.softwareii.doglove.inicio;

import java.util.List;

import pe.edu.softwareii.doglove.model.dto.Mascota;

/**
 * Created by hquintana on 26/09/15.
 */
public interface InicioView {
    public void onListaMascotasLoaded(List<Mascota> mascotas);
    public void onError(String error);
}
