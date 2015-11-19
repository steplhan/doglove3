package pe.edu.softwareii.doglove.inicio;


import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.softwareii.doglove.R;
import pe.edu.softwareii.doglove.model.dto.Mascota;


public class InicioFragment extends Fragment implements InicioView,OnClickListener{

    private static List<Mascota> mMascotas;
    private static Mascota mMascota;
    private Button butYES;
    private Button butNO;
    private ImageView iviFoto;
    private TextView tviNombreEdad;
    private ProgressDialog pd;
    private InicioActions listener;


    public static InicioFragment newInstance(){
        return new InicioFragment();
    }


    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (InicioActions) getActivity();
        }catch(ClassCastException cce){
            new RuntimeException("El activity debe de implementar QueHaciendoActions");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (InicioActions) getActivity();
        }catch(ClassCastException cce){
            new RuntimeException("El activity debe de implementar QueHaciendoActions");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        pd = ProgressDialog.show(
                getActivity(),
                getString(R.string.titulo_progress),
                getString(R.string.mensaje_progress));
        new InicioPresenter(this).listarMascotas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        listener.setTitle("Match");
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        tviNombreEdad = (TextView) view.findViewById(R.id.tviNombreEdadMatch);
        butYES=(Button)view.findViewById(R.id.butYES);
        butNO=(Button)view.findViewById(R.id.butNO);
        iviFoto=(ImageView)view.findViewById(R.id.iviFotoMascotaMatch);

        butYES.setOnClickListener(this);
        butNO.setOnClickListener(this);

        return view;
    }


    @Override
    public void onListaMascotasLoaded(List<Mascota> mascotas) {
        if (pd.isShowing()){
            pd.dismiss();
        }
        mMascotas=mascotas;
        mMascota=mMascotas.get(0);
        tviNombreEdad.setText(mMascota.getNombreMascota()+", "+mMascota.getEdad()+" años");
        //Cambiar foto

    }

    @Override
    public void onError(String error) {
        if (pd.isShowing()){
            pd.dismiss();
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.butYES:
                //Notificar a backend
                mMascota=mMascotas.get(mMascotas.indexOf(mMascota)+1);
                tviNombreEdad.setText(mMascota.getNombreMascota()+", "+mMascota.getEdad()+" años");
                //Cambiar foto
            case R.id.butNO:
                //Notificar a backend
                mMascota=mMascotas.get(mMascotas.indexOf(mMascota)+1);
                tviNombreEdad.setText(mMascota.getNombreMascota()+", "+mMascota.getEdad()+" años");
                //Cambiar foto
        }

    }


    public interface InicioActions{
        public void setTitle(String titulo);

    }
}
