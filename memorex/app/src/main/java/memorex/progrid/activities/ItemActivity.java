package memorex.progrid.activities;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.Serializable;

import memorex.progrid.base.Item;
import memorex.progrid.base.ManipuladorJson;
import memorex.progrid.memorex2.R;

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
