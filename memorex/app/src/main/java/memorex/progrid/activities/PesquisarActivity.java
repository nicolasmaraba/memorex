package memorex.progrid.activities;

import android.content.Intent;
import android.provider.Settings;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import memorex.progrid.adapters.ListAdapterDia;
import memorex.progrid.base.Dia;
import memorex.progrid.base.Item;
import memorex.progrid.http.URLsolicita;
import memorex.progrid.memorex2.R;

public class PesquisarActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private Dia dia;
    //private ListView listaBusca;
    private String[] itensBuscados = {"1"};
    //private String[] detalhesDoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);
        //implementa a toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//Suporta o actionbar
        //Implementa a lista
        RelativeLayout linear = (RelativeLayout) View.inflate(this,
                R.layout.activity_dia, null);
        ActivityBase chamaCommon = new ActivityBase();
        List<Dia> dias = chamaCommon.common.mes.getDias();
        int mes = chamaCommon.common.mes.getMes();
        int ano = chamaCommon.common.mes.getAno();

        Intent intent = getIntent();
        Serializable objeto = intent.getSerializableExtra("dia");
        if (objeto !=null) {
            dia = (Dia) objeto;
            dias = new ArrayList<Dia>();
            dias.add(dia);

            mes = dia.getMes();
            ano = dia.getAno();
        }
        ExpandableListView list = (ExpandableListView) findViewById(R.id.listDia);
        list.setAdapter(new ListAdapterDia(this, R.layout.list_dia, dias, mes, ano));
        list.setOnChildClickListener(clickItem);

    }

    private ExpandableListView.OnChildClickListener clickItem = new ExpandableListView.OnChildClickListener() {
        @Override
        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {
            Intent intent = new Intent(PesquisarActivity.this, ItemActivity.class);
            ActivityBase chamaCommon = new ActivityBase();
            Item item = chamaCommon.common.mes.getDias().get(groupPosition).getItens().get(childPosition);
            intent.putExtra("item", item);
            startActivity(intent);

            return false;
        }
    };

    //chamando o inflate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        //searchItem.expandActionView();
        return true;
    }


    //Implementa a Submissão do Buscar (quando clica na Lupa)
    @Override
    public boolean onQueryTextSubmit(String query) {

        URLsolicita chama = new URLsolicita();
        String json = chama.jsonToObject();
        Log.i("json: ", json);//Este é só para teste, se quiser pode apagar ou comentar
        // Deixo o código abaixo comentado para informar como que é feita a pesquisa e adicionada a
        //lista. Lembrando que a variável JSON já está populada com o REST
        /**
         Gson g = new Gson();
         Type clienteType = new TypeToken<Cliente>() {}.getType();
         c =  g.fromJson(resultado, clienteType);
         Log.i("Nome: ", c.getNome());
         //texto.setText("CC é: " + c.getCc());
         itensBuscados [0] = c.getNome();

         listaBusca = (ListView) findViewById(R.id.listaBuscar);
         ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
         getApplicationContext(),
         android.R.layout.simple_list_item_1,
         android.R.id.text1,
         itensBuscados
         );
         listaBusca.setAdapter(adaptador);

         }catch (Exception ex){
         Log.i("Erro de List é: ", ex.getMessage());
         }
         */
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}