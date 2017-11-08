package memorex.progrid.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.Serializable;

import memorex.progrid.base.Item;
import memorex.progrid.base.ManipuladorJson;
import memorex.progrid.memorex2.R;
import android.app.AlertDialog.Builder;

/**
 * Created by progrid on 19/10/17.
 */
public class ItemActivity extends AppCompatActivity {

    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item);

        Intent intent = getIntent();
        Serializable objeto = intent.getSerializableExtra("item");
        if (objeto !=null)
            item = (Item) objeto;

        ImageView btnBack = (ImageView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//----------------------------------------------TRATAMENTO DO SEGMENTO "SOLUÇÕES"-----------------------------------------//

        final LinearLayout solutionOpened = (LinearLayout) findViewById(R.id.solutionOpened); //Configura como VISIBLE por default
        final LinearLayout solutionClosed = (LinearLayout) findViewById(R.id.solutionClosed);
        final LinearLayout solutionList = (LinearLayout) findViewById(R.id.solutionList);
        solutionOpened.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                solutionList.setVisibility(View.GONE);
                solutionOpened.setVisibility(View.GONE);
                solutionClosed.setVisibility(View.VISIBLE);
            }

        });

        solutionClosed.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                solutionList.setVisibility(View.VISIBLE);
                solutionOpened.setVisibility(View.VISIBLE);
                solutionClosed.setVisibility(View.GONE);
            }

        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Abrir esta operação no app 'BB' ?")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });

        LinearLayout btnPoupanca = (LinearLayout) findViewById(R.id.btnPoupanca);
        btnPoupanca.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                AlertDialog alert = builder.create();
                alert.show();

            }

        });

        LinearLayout btnCredito = (LinearLayout) findViewById(R.id.btnCredito);
        btnCredito.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                AlertDialog alert = builder.create();
                alert.show();

            }

        });



    //----------------------------------------------TRATAMENTO DO SEGMENTO "DADOS"----------------------------------------//

        /*Button btnFechar = (Button) findViewById(R.id.btnFechar);
        final LinearLayout alertLayout = (LinearLayout) findViewById(R.id.alertLayout);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertLayout.setVisibility(View.GONE);
            }
        });*/// Caso seja usado o botão _fechar_

        final LinearLayout dataOpened = (LinearLayout) findViewById(R.id.dataOpened);
        final LinearLayout dataClosed = (LinearLayout) findViewById(R.id.dataClosed);
        final LinearLayout dataList = (LinearLayout) findViewById(R.id.dataList);
        dataOpened.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                dataList.setVisibility(View.GONE);
                dataOpened.setVisibility(View.GONE);
                dataClosed.setVisibility(View.VISIBLE);
            }

        });

        dataClosed.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                dataList.setVisibility(View.VISIBLE);
                dataOpened.setVisibility(View.VISIBLE);
                dataClosed.setVisibility(View.GONE);
            }

        });



        TextView txtNome = (TextView) findViewById(R.id.txtNome);
        txtNome.setText(item.getNome());
        TextView txtValor = (TextView) findViewById(R.id.txtValor);
        txtValor.setText(item.getValor());
        TextView txtData = (TextView) findViewById(R.id.txtData);
        txtData.setText(item.getData_agendamento().toString());
        TextView txtCdBarra = (TextView) findViewById(R.id.txtCdBarra);
        txtCdBarra.setText(item.getCodigo_barra());




    }

}
