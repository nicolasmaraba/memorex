package memorex.progrid.adaters;

import memorex.progrid.base.Item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by progrid on 19/10/17.
 */
public class ListAdapter extends ArrayAdapter<Item> {

    private int textViewResourceId;
    private List<Item> itens;

    public ListAdapter(Context context, int textViewResourceId, List<Item> itens) {
        super(context, textViewResourceId, itens);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        View v = convertView;

        return v;
    }

    static class ViewHolder {

        Item item;
    }
}
