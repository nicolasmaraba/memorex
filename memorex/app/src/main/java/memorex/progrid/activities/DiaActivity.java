package memorex.progrid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import memorex.progrid.adapters.ListAdapterDia;
import memorex.progrid.base.Dia;
import memorex.progrid.base.Item;
import memorex.progrid.base.ManipuladorJson;
import memorex.progrid.base.Mes;
import memorex.progrid.memorex2.R;

/**
 * Created by progrid on 19/10/17.
 */
public class DiaActivity extends ActivityBase {

    private Dia dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout linear = (RelativeLayout) View.inflate(this,
                R.layout.activity_dia, null);
        base.addView(linear, new ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT));

        List<Dia> dias = common.mes.getDias();
        int mes = common.mes.getMes();
        int ano = common.mes.getAno();

        Intent intent = getIntent();
        Serializable objeto = intent.getSerializableExtra("dia");
        if (objeto !=null) {
            dia = (Dia) objeto;
            dias = new ArrayList<Dia>();
            dias.add(dia);

            mes = dia.getMes();
            ano = dia.getAno();

            btnListOrCal.setImageResource(R.drawable.back);
            btnListOrCal.invalidate();

            btnListOrCal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else
        {
            btnListOrCal.setImageResource(R.drawable.calendar);
            btnListOrCal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(DiaActivity.this, CalendarActivity.class));
                    finish();
                }
            });
        }

        ExpandableListView list = (ExpandableListView) findViewById(R.id.listDia);

        list.setAdapter(new ListAdapterDia(this, R.layout.list_dia, dias, mes, ano));

        list.setOnChildClickListener(clickItem);

    }

    private ExpandableListView.OnChildClickListener clickItem = new ExpandableListView.OnChildClickListener() {
        @Override
        public boolean onChildClick(ExpandableListView parent, View v,
                                 int groupPosition, int childPosition, long id) {
            Intent intent = new Intent(DiaActivity.this, ItemActivity.class);
            Item item = common.mes.getDias().get(groupPosition).getItens().get(childPosition);
            intent.putExtra("item", item);
            startActivity(intent);

            return false;
        }
    };

}
