package pe.edu.softwareii.doglove.veterinarias;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import pe.edu.softwareii.doglove.R;
import pe.edu.softwareii.doglove.model.dto.Veterinaria;


public class VeterinariasFragment extends Fragment implements VeterinariasView, AdapterView.OnItemClickListener{
    private ListView lviVeterinarias;
    private ProgressDialog pd;
    private QueHaciendoActions listener;


    public static VeterinariasFragment newInstance(){
        return new VeterinariasFragment();
    }


    public VeterinariasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        pd = ProgressDialog.show(
                getActivity(),
                getString(R.string.titulo_progress),
                getString(R.string.mensaje_progress));
        new VeterinariasPresenter(this).listarVeterinarias();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //listener.setTitle("VETERINARIAS");
        View view = inflater.inflate(R.layout.fragment_veterinarias, container, false);
        lviVeterinarias = (ListView) view.findViewById(R.id.lviVeterinarias);
        return view;
    }

    @Override
    public void onListaVeterinariasLoaded(List<Veterinaria> veterinarias) {
        if (pd.isShowing()){
            pd.dismiss();
        }
        ListaVeterinariasAdapter adapter = new ListaVeterinariasAdapter(veterinarias, getActivity());
        lviVeterinarias.setAdapter(adapter);
        lviVeterinarias.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        listener.onVeterinariaSelected((Veterinaria) adapterView.getItemAtPosition(i));
    }

    @Override
    public void onError(String error) {
        if (pd.isShowing()){
            pd.dismiss();
        }
    }


    public interface QueHaciendoActions{
        public void setTitle(String titulo);
        public void onVeterinariaSelected(Veterinaria veterinaria);
    }
}
