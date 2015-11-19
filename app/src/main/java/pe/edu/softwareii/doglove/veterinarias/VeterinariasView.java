package pe.edu.softwareii.doglove.veterinarias;

import java.util.List;

import pe.edu.softwareii.doglove.model.dto.Veterinaria;

/**
 * Created by hquintana on 26/09/15.
 */
public interface VeterinariasView {
    public void onListaVeterinariasLoaded(List<Veterinaria> veterinarias);
    public void onError(String error);
}
