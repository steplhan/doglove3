package pe.edu.softwareii.doglove.perfil;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.softwareii.doglove.ApplicationController;
import pe.edu.softwareii.doglove.R;
import pe.edu.softwareii.doglove.model.dto.Mascota;
import pe.edu.softwareii.doglove.model.dto.Usuario;


public class PerfilFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Usuario u= ApplicationController.getApplicationController().getmUsuario();
        Mascota m=ApplicationController.getApplicationController().getmMascota();

        View view=inflater.inflate(R.layout.fragment_perfil2, container);

        ImageView iviFoto=(ImageView)view.findViewById(R.id.iviFoto);
        TextView tviNombreEdad=(TextView)view.findViewById(R.id.tviNombreEdad);
        TextView tviDescripcion=(TextView)view.findViewById(R.id.tviDescripcion);
        TextView tviNombreUsuario=(TextView)view.findViewById(R.id.tviNombreUsuario);
        TextView tviEmail=(TextView)view.findViewById(R.id.tviEmail);

        tviNombreEdad.setText(m.getNombreMascota()+", "+m.getFechaNac()/*m.getEdad()+" años"*/);
        tviDescripcion.setText(m.getDescripcion());
        tviNombreUsuario.setText(u.getNombre());
        tviEmail.setText(u.getEmail());
        //iviFoto.setImageResource(m.getFoto());

        int targetW = iviFoto.getWidth();
        int targetH = iviFoto.getHeight();

        //Picasso.with(this.getContext()).load().resize(targetW, targetH).centerCrop().into(iviFoto);

        /*if(m.getRaza()==0){

        }else if(m.getRaza()==1){
            iviFoto.setImageResource(R.drawable.labrador);
        }else if(m.getRaza()==2){
            iviFoto.setImageResource(R.drawable.bullterrier);
        }else if(m.getRaza()==3) {
            iviFoto.setImageResource(R.drawable.bulldog);
        }else if(m.getRaza()==4){
            iviFoto.setImageResource(R.drawable.bullterrier);
        }*/



        return view;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
