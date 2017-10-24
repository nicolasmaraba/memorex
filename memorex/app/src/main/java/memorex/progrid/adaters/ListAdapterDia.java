package memorex.progrid.adapters;

import memorex.progrid.base.Dia;
import memorex.progrid.base.Item;
import memorex.progrid.memorex2.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by progrid on 19/10/17.
 */
public class ListAdapterDia extends BaseExpandableListAdapter {

    private int textViewResourceId;
    private List<Dia> dias;
    private Context context;
    private int mes;
    private int ano;

    public ListAdapterDia(Context context, int textViewResourceId, List<Dia> dias, int mes, int ano) {

        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.dias = dias;
        this.mes = mes;
        this.ano = ano;
    }
    @Override
    public int getGroupCount() {
        // retorna a quantidade de grupos
        return dias.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // retorna a quantidade de itens de um grupo
        return dias.get(groupPosition).getItens().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // retorna um grupo
        return dias.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // retorna um item do grupo
        return dias.get(groupPosition).getItens().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        // retorna o id do grupo, porém como nesse exemplo
        // o grupo não possui um id específico, o retorno
        // será o próprio groupPosition
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // retorna o id do item do grupo, porém como nesse exemplo
        // o item do grupo não possui um id específico, o retorno
        // será o próprio childPosition
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        // retorna se os ids são específicos (únicos para cada
        // grupo ou item) ou relativos
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // cria os itens principais (grupos)

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_dia, null);
        }

        TextView txtDia = (TextView) convertView.findViewById(R.id.txtDia);

        txtDia.setText(dias.get(groupPosition).getDia() + "/" + mes + "/" + ano);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // cria os subitens (itens dos grupos)

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView txtNome = (TextView) convertView.findViewById(R.id.txtNome);
        TextView txtValor = (TextView) convertView.findViewById(R.id.txtValor);

        Item item = (Item) getChild(groupPosition, childPosition);
        txtNome.setText(item.getNome());
        txtValor.setText(item.getValor());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // retorna se o subitem (item do grupo) é selecionável
        return true;
    }

    static class ViewHolder {

        Context context;

        TextView txtDia;
        ListView listTitulos;

        Dia dia;
    }
}
