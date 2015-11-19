package pe.edu.softwareii.doglove.inicio;

/**
 * Created by JORGE on 02/11/2015.
 */
public class PosiblesMatchesRequest {
    private int genero;
    private int raza;

    public PosiblesMatchesRequest() {
    }

    public PosiblesMatchesRequest(int genero, int raza) {
        this.genero = genero;
        this.raza = raza;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getRaza() {
        return raza;
    }

    public void setRaza(int raza) {
        this.raza = raza;
    }
}
