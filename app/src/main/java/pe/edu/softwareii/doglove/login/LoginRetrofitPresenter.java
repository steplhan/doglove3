package pe.edu.softwareii.doglove.login;

import pe.edu.softwareii.doglove.model.dao.DogloveService;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class LoginRetrofitPresenter implements ILoginPresenter{
    private static final String url = "http://dev03.presla.co";

    private LoginView view;

    public LoginRetrofitPresenter(LoginView view){
        this.view = view;
    }

    @Override
    public void login(String nombre,String apellidop,String apellidom, String email) {

        /*if(usuario.equals("jorge") && password.equals("123")){
            view.onLoginCorrecto(new Usuario("Jorge","Tejada","Loarte","jorgetl26@gmail.com"));
        }else{
            view.onLoginIncorrecto();
        }*/
        LoginRequest loginRequest = new LoginRequest(nombre,apellidop,apellidom,email);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DogloveService service = retrofit.create(DogloveService.class );

        service.login(loginRequest).enqueue(new Callback<GenericResponse>() {
            @Override
            public void onResponse(Response<GenericResponse> response, Retrofit retrofit) {
                //Log.i("msgStatus: ", response.body().getMascotas()[0].getNombreMascota());
                if (response.body().getMsgStatus().equals("OK")) {
                    view.onLoginCorrecto(response.body().getUsuario(),response.body().getMascotas());
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


//        service.login(new RequestBody() {
//            @Override
//            public MediaType contentType() {
//                return MediaType.parse("application/json");
//            }
//
//            @Override
//            public void writeTo(BufferedSink sink) throws IOException {
//                sink.write(json.getBytes());
//            }
//        }).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Response<ResponseBody> response) {
//                GenericResponse loginResponse =
//                        null;
//                try {
//                    Log.i("LoginRetrofitPresenter", response.body().string());
//                    loginResponse = new Gson().fromJson(response.body().string(), GenericResponse.class);
//
//                    if (loginResponse.getMsgStatus().equals("OK")) {
//                        view.onLoginCorrecto();
//                    } else if (loginResponse.getMsgStatus().equals("ERROR")) {
//                        view.onLoginIncorrecto();
//                    } else {
//                        view.onError(loginResponse.getMsgError());
//                    }
//
//                } catch (IOException e) {
//                    view.onError("LoginPresenter (4XX): " + e.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                view.onError("LoginPresenter (5XX): " + t.getMessage());
//            }
//        });
    }
}
