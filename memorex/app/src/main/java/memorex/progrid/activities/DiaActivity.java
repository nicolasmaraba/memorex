package memorex.progrid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONException;

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

    private Mes mes;
    private Dia dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout linear = (RelativeLayout) View.inflate(this,
                R.layout.activity_dia, null);
        base.addView(linear, new ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT));

        try {
            Log.i("memorex", "***************************iniciou");
            loadDia();
            Log.i("memorex", "***************************passou");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ExpandableListView list = (ExpandableListView) findViewById(R.id.listDia);

        list.setAdapter(new ListAdapterDia(this, R.layout.list_dia, mes.getDias(), mes.getMes(), mes.getAno()));

        list.setOnChildClickListener(clickItem);

    }

    private ExpandableListView.OnChildClickListener clickItem = new ExpandableListView.OnChildClickListener() {
        @Override
        public boolean onChildClick(ExpandableListView parent, View v,
                                 int groupPosition, int childPosition, long id) {
            Intent intent = new Intent(DiaActivity.this, ItemActivity.class);
            Item item = mes.getDias().get(groupPosition).getItens().get(childPosition);
            intent.putExtra("item", item);
            startActivity(intent);

            return false;
        }
    };

    private void loadDia() throws JSONException {

        String json = "{\n" +
                "  \"mes\": 10,\n" +
                "  \"ano\": 2017,\n" +
                "  \"dias\":[\n" +
                "    {\n" +
                "      \"dia\":1,\n" +
                "      \"titulos\": [\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"asd\",\n" +
                "          \"valor\": \"R$4050,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdsaf\",\n" +
                "          \"valor\": \"R$50,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"2a\",\n" +
                "          \"valor\": \"R$450,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2,\n" +
                "          \"sinal\": 2,\n" +
                "          \"grupo\": 2,\n" +
                "          \"nome\": \"1b\",\n" +
                "          \"valor\": \"R$40,00\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"dia\":13,\n" +
                "      \"titulos\": [\n" +
                "        {\n" +
                "          \"id\": 3,\n" +
                "          \"sinal\": 3,\n" +
                "          \"grupo\": 3,\n" +
                "          \"nome\": \"13a\",\n" +
                "          \"valor\": \"R$450,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 4,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"13b\",\n" +
                "          \"valor\": \"R$40,00\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"dia\":16,\n" +
                "      \"titulos\": [\n" +
                "        {\n" +
                "          \"id\": 5,\n" +
                "          \"sinal\": 5,\n" +
                "          \"grupo\": 2,\n" +
                "          \"nome\": \"16a\",\n" +
                "          \"valor\": \"R$52,00\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"dia\":18,\n" +
                "      \"titulos\": [\n" +
                "        {\n" +
                "          \"id\": 6,\n" +
                "          \"sinal\": 4,\n" +
                "          \"grupo\": 3,\n" +
                "          \"nome\": \"18a\",\n" +
                "          \"valor\": \"R$52,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 7,\n" +
                "          \"sinal\": 5,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"18a\",\n" +
                "          \"valor\": \"R$2,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 8,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 2,\n" +
                "          \"nome\": \"18a\",\n" +
                "          \"valor\": \"R$2000,00\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        mes = ManipuladorJson.jsonMesToBase(json);
        dia = mes.getDias().get(0);
        Toast.makeText(getApplicationContext(), "certo",Toast.LENGTH_LONG).show();
    }

}
