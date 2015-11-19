package pe.edu.softwareii.doglove.veterinarias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.softwareii.doglove.R;
import pe.edu.softwareii.doglove.model.dto.Veterinaria;


/**
 * Created by hquintana on 26/09/15.
 */
public class ListaVeterinariasAdapter extends BaseAdapter {
    private List<Veterinaria> mVeterinarias;
    private Context mContext;

    public ListaVeterinariasAdapter(List<Veterinaria> veterinarias, Context context){
        mVeterinarias = veterinarias;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mVeterinarias.size();
    }

    @Override
    public Object getItem(int i) {
        return mVeterinarias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mVeterinarias.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_veterinarias, null);

            viewHolder = new ViewHolder();
            viewHolder.iviLogo = (ImageView)view.findViewById(R.id.iviLogo);
            viewHolder.tviNombre = (TextView)view.findViewById(R.id.tviNombreVeterinaria);
            viewHolder.tviDireccion = (TextView)view.findViewById(R.id.tviDireccion);
            viewHolder.tviTelefono = (TextView)view.findViewById(R.id.tviTelefono);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }

        Veterinaria veterinaria = mVeterinarias.get(i);

        viewHolder.iviLogo.setImageResource(R.drawable.patita);
        viewHolder.tviNombre.setText(veterinaria.getNombre());
        viewHolder.tviDireccion.setText(veterinaria.getDireccion());
        viewHolder.tviTelefono.setText(veterinaria.getTelefono());



        return view;
    }

    class ViewHolder{
        ImageView iviLogo;
        TextView tviNombre;
        TextView tviDireccion;
        TextView tviTelefono;
    }
}
