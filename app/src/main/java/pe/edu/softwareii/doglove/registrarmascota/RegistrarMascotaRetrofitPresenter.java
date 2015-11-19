package pe.edu.softwareii.doglove.registrarmascota;

import pe.edu.softwareii.doglove.ApplicationController;
import pe.edu.softwareii.doglove.model.dao.DogloveService;
import pe.edu.softwareii.doglove.model.dto.Mascota;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by JORGE on 06/10/2015.
 */
public class RegistrarMascotaRetrofitPresenter implements  IResgistrarMascotaPresenter{


    private static final String url = "http://dev03.presla.co";
    private RegistroMascotaView view;


    public RegistrarMascotaRetrofitPresenter(RegistroMascotaView view){
        this.view = view;
    }

    @Override
    public void registrarMascota(final Mascota mascota) {

        RegistrarMascotaRequest registrarMascotaRequest = new RegistrarMascotaRequest(mascota.getNombreMascota(),mascota.getFoto(),mascota.getRaza(),
                mascota.getGenero(),mascota.getFechaNac());
        //final String json = new Gson().toJson(registrarMascotaRequest);

        //Log.i("json",json);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DogloveService service = retrofit.create(DogloveService.class);

        service.registrarMascota(registrarMascotaRequest).enqueue(new Callback<RegistrarMacotaResponse>() {
            @Override
            public void onResponse(Response<RegistrarMacotaResponse> response, Retrofit retrofit) {


                if (response.body().getMsgStatus().equals("OK")) {
                    ApplicationController.getApplicationController().setmMascota(mascota);
                    view.onRegistroCorrecto();
                } else if (response.body().getMsgStatus().equals("ERROR")) {
                    view.onRegistroIncorrecto();
                } else {
                    view.onError(response.body().getMsgError());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                view.onError("RegistroPresenter (5XX): " + t.getMessage());
            }
        });


    }
}
