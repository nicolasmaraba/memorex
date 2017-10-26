package memorex.progrid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import memorex.progrid.base.Item;
import memorex.progrid.memorex2.R;

/**
 * Created by progrid on 19/10/17.
 */
public class ListAdapterItem extends ArrayAdapter<Item> {

    private int textViewResourceId;
    private List<Item> itens;
    private Context context;

    public ListAdapterItem(Context context, int textViewResourceId, List<Item> itens) {
        super(context, textViewResourceId, itens);

        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.itens = itens;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        View v = convertView;

        try {
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(textViewResourceId, null);

                holder = new ViewHolder();
                holder.item = itens.get(position);

                holder.image = (ImageView) v.findViewById(R.id.imgTitulo);
                holder.txtNome = (TextView) v.findViewById(R.id.txtNome);
                holder.txtValor = (TextView) v.findViewById(R.id.txtValor);
                holder.context = this.context;

                v.setTag(holder);
            } else {
                holder = (ViewHolder) v.getTag();
                holder.item = itens.get(position);
            }
            if (holder.item != null) {

                if (holder.txtNome != null) {
                    holder.txtNome.setText(holder.item.getNome());
                    holder.txtNome.setTag(holder.item.getId());
                }

                if (holder.txtValor != null) {
                    holder.txtValor.setText(holder.item.getValor());
                    holder.txtValor.setTag(holder.item.getId());
                }

                if (holder.image != null) {

                    holder.image.setImageResource(R.drawable.icon_boleto);

                }
            }


        } catch (Exception exc) {

        }
        return v;
    }

    static class ViewHolder {

        Context context;

        ImageView image;
        TextView txtNome;
        TextView txtValor;

        Item item;
    }
}
