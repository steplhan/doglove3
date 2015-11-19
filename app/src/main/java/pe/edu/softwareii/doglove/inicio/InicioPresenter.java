package pe.edu.softwareii.doglove.inicio;

import pe.edu.softwareii.doglove.ApplicationController;
import pe.edu.softwareii.doglove.model.dao.DogloveService;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by hquintana on 26/09/15.
 */
public class InicioPresenter implements IInicioPresenter{
    private static final String url = "http://dev03.presla.co";

    private InicioView mView;

    public InicioPresenter(InicioView view){
        mView = view;
    }

    @Override
    public void listarMascotas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DogloveService service = retrofit.create(DogloveService.class);

        int genero=0;
        if(ApplicationController.getApplicationController().getmMascota().getGenero().equals("M"))
            genero=1;

        service.obtenerPosiblesMatches(new PosiblesMatchesRequest(genero,
                ApplicationController.getApplicationController().getmMascota().getRaza())).enqueue(new Callback<PosiblesMatchesResponse>() {
            @Override
            public void onResponse(Response<PosiblesMatchesResponse> response, Retrofit retrofit) {
                if (response.body().getMsgStatus().equals("OK")) {
                    mView.onListaMascotasLoaded(response.body().getMascotas());
                } else{
                    mView.onError(response.body().getMsgError());
                }
            }



            @Override
            public void onFailure(Throwable t) {
                mView.onError("InicioPresenter (5XX): " + t.getMessage());
            }
        });
    }
}
