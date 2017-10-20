package memorex.progrid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import memorex.progrid.adaters.ListAdapter;
import memorex.progrid.base.Dia;
import memorex.progrid.base.Item;
import memorex.progrid.base.ManipuladorJson;
import memorex.progrid.base.Mes;
import memorex.progrid.memorex.R;

/**
 * Created by progrid on 19/10/17.
 */
public class DiaActivity extends ActivityBase {

    private Mes mes;
    private Dia dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linear = (LinearLayout) View.inflate(this,
                R.layout.activity_dia, null);
        base.addView(linear, new ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT));

        loadDia();

        ListView list = (ListView) findViewById(R.id.listDia);

        list.setAdapter(new ListAdapter(this, R.layout.list_item, dia.getItens()));

    }

    private AdapterView.OnItemClickListener clickMagazine =new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(DiaActivity.this, ItemActivity.class);
            Item item = dia.getItens().get(i);
            intent.putExtra("item", item);
            startActivity(intent);
        }
    };

    private void loadDia(){
        //mes = ManipuladorJson.jsonMesToBase();
    }

}
