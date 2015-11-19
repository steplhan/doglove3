package pe.edu.softwareii.doglove.veterinarias;

import pe.edu.softwareii.doglove.model.dao.DogloveService;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by hquintana on 26/09/15.
 */
public class VeterinariasPresenter implements IVeterinariasPresenter{
    private static final String url = "http://dev03.presla.co";

    private VeterinariasView mView;

    public VeterinariasPresenter(VeterinariasView view){
        mView = view;
    }

    @Override
    public void listarVeterinarias() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DogloveService service = retrofit.create(DogloveService.class);

        service.obtenerVeterinarias().enqueue(new Callback<ObtenerVeterinariasResponse>() {
            @Override
            public void onResponse(Response<ObtenerVeterinariasResponse> response, Retrofit retrofit) {
                if (response.body().getMsgStatus().equals("ERROR")) {
                    mView.onListaVeterinariasLoaded(response.body().getVeterinarias());
                } else {
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
