package pe.edu.softwareii.doglove;

import android.app.Application;

import pe.edu.softwareii.doglove.model.dto.Mascota;
import pe.edu.softwareii.doglove.model.dto.Usuario;

/**
 * Created by JORGE on 06/10/2015.
 */
public class ApplicationController extends Application {
    private Usuario mUsuario;
    private Mascota mMascota;
    private static ApplicationController applicationController;

    private ApplicationController() {
    }



    public  static ApplicationController getApplicationController() {

        if (applicationController==null)
            applicationController=new ApplicationController();
        return applicationController;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public Usuario getmUsuario() {
        return mUsuario;
    }

    public void setmUsuario(Usuario mUsuario) {
        this.mUsuario = mUsuario;
    }

    public Mascota getmMascota() {
        return mMascota;
    }

    public void setmMascota(Mascota mMascota) {
        this.mMascota = mMascota;
    }
}
