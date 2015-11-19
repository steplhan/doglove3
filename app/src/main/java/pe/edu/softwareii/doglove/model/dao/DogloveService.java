package pe.edu.softwareii.doglove.model.dao;


import pe.edu.softwareii.doglove.inicio.PosiblesMatchesRequest;
import pe.edu.softwareii.doglove.inicio.PosiblesMatchesResponse;
import pe.edu.softwareii.doglove.login.GenericResponse;
import pe.edu.softwareii.doglove.login.LoginRequest;
import pe.edu.softwareii.doglove.registrarmascota.ObtenerRazasResponse;
import pe.edu.softwareii.doglove.registrarmascota.RegistrarMacotaResponse;
import pe.edu.softwareii.doglove.registrarmascota.RegistrarMascotaRequest;
import pe.edu.softwareii.doglove.veterinarias.ObtenerVeterinariasResponse;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

//import pe.edu.softwareii.doglove.veterinarias.ObtenerVeterinariasResponse;

public interface DogloveService {
    @POST("/login3")
    Call<GenericResponse> login(@Body LoginRequest request);

    //@POST("/loginfb")
    //Call<GenericResponse> loginfb(@Body )

    @POST("/registrar")
    Call<RegistrarMacotaResponse> registrarMascota(@Body RegistrarMascotaRequest request);


    /*
     ObtenerRazasResponse:
        String msgStatus;
        String msgError;
        List<Raza> razas;

     Raza:
        int id_raza;
        int nombre;
     */
    @GET("/obtenerRazas")
    Call<ObtenerRazasResponse> obtenerRazas();

    @GET("/veterinarias")
    Call<ObtenerVeterinariasResponse> obtenerVeterinarias();



    @POST("/inicio")
    Call<PosiblesMatchesResponse> obtenerPosiblesMatches(@Body PosiblesMatchesRequest request);


    /*
    @GET("/momentos/{id}")
    Call<ObtenerMomentosResponse> obtenerMomentos(@Path("id") long idUsuario);

    @Multipart
    @POST("momentos")
    Call<GenericResponse> registrarMomento(
            @Part("foto") RequestBody photo,
            @Part("idUsuario") RequestBody idUsuario,
            @Part("lugar") RequestBody lugar,
            @Part("fecha") RequestBody fechas,
            @Part("latitud") RequestBody latitud,
            @Part("longitud") RequestBody longitud);*/
}
