package pe.edu.softwareii.doglove.perfil;

import pe.edu.softwareii.doglove.ApplicationController;

/**
 * Created by JORGE on 06/10/2015.
 */
public class PerfilPresenter implements IPerfilPresenter{

    private static final String url = "http://dev03.presla.co";


    @Override
    public void perfil() {
        ApplicationController applicationController=ApplicationController.getApplicationController();



    }
/*
    @Override
    public void perfil2(String idMascota) {

        LoginRequest loginRequest = new LoginRequest(usuario, password);
        final String json = new Gson().toJson(loginRequest);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DogloveService service = retrofit.create(DogloveService.class );

        service.login(loginRequest).enqueue(new Callback<GenericResponse>() {
            @Override
            public void onResponse(Response<GenericResponse> response, Retrofit retrofit) {
                if (response.body().getMsgStatus().equals("OK")) {
                    view.onLoginCorrecto(response.body().getUsuario());
                } else if (response.body().getMsgStatus().equals("ERROR")) {
                    view.onLoginIncorrecto();
                } else {
                    view.onError(response.body().getMsgError());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                view.onError("LoginPresenter (5XX): " + t.getMessage());
            }
        });
*/



}
