package memorex.progrid.activities;

import android.graphics.MaskFilter;
import android.os.Bundle;
import android.text.style.MaskFilterSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.DataTruncation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.DataFormatException;

import javax.xml.datatype.DatatypeConfigurationException;

import memorex.progrid.base.Item;
import memorex.progrid.memorex2.R;

public class LembreteActivity extends ActivityBase {

    private ArrayList<Integer> itensDia;
    private EditText editTextLembrete;
    private EditText editTextData;
    private int iFrequencia, iDia;
    private Date dtEventual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Não sei o que é esse Linear
        LinearLayout linear = (LinearLayout) View.inflate(this,
                R.layout.activity_lembrete, null);
        base.addView(linear, new ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT));
        setContentView(R.layout.activity_lembrete);
        // Apontando os componentes da tela activity xml
        final Spinner spinnerDia = (Spinner) findViewById(R.id.spinnerDia);
        final TextView textViewDia = (TextView) findViewById(R.id.textViewDia);
        final Spinner spinnerFrequencia = (Spinner) findViewById(R.id.spinnerFrequencia);
        editTextLembrete = (EditText) findViewById(R.id.editTextLembrete);
        editTextData = (EditText) findViewById(R.id.editTextData);
        final TextView textViewData = (TextView) findViewById(R.id.textViewData);
        final Button btnSalvar = (Button) findViewById(R.id.btnSalvar);

        setItensDia();
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, itensDia);
        ArrayAdapter<Integer> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerDia.setAdapter(spinnerArrayAdapter);
        // Iniciando as variáveis
        iFrequencia = 0;
        iDia = 1;
        // Desabilitando todos os campos
        spinnerDia.setVisibility(View.GONE);
        textViewDia.setVisibility(View.GONE);
        textViewData.setVisibility(View.GONE);
        editTextData.setVisibility(View.GONE);

        spinnerFrequencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                iFrequencia = arg2;
                if (iFrequencia == 2) {
                    spinnerDia.setVisibility(View.VISIBLE);
                    textViewDia.setVisibility(View.VISIBLE);
                    textViewData.setVisibility(View.GONE);
                    editTextData.setVisibility(View.GONE);
                }
                if (iFrequencia == 1) {
                    spinnerDia.setVisibility(View.GONE);
                    textViewDia.setVisibility(View.GONE);
                    textViewData.setVisibility(View.VISIBLE);
                    editTextData.setVisibility(View.VISIBLE);
                }
                if (iFrequencia == 0) {
                    spinnerDia.setVisibility(View.GONE);
                    textViewDia.setVisibility(View.GONE);
                    textViewData.setVisibility(View.GONE);
                    editTextData.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // Nada
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextLembrete.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(), "Informe a descrição", Toast.LENGTH_LONG).show();
                }else {
                    if (iFrequencia == 0){
                        Toast.makeText(getApplicationContext(), "Escolha a periodicidade", Toast.LENGTH_LONG).show();
                    }else {
                        salvarDados();
                    }
                }

            }
        });

        spinnerDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                iDia = Integer.valueOf(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void salvarDados() {
        String sFrequencia = "";

        if (iFrequencia == 1) {
            sFrequencia = "Eventual";
            Boolean bDataCorreta;
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            String dataEvento = editTextData.getText().toString();
            try {
                Date date = formato.parse(dataEvento);
                bDataCorreta = true;
            } catch (ParseException e) {
                bDataCorreta = false;
            }
            if (bDataCorreta) {
                Toast.makeText(getApplicationContext(), editTextLembrete.getText().toString() + " " + sFrequencia + " dia " + editTextData.getText().toString(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Data inválida", Toast.LENGTH_LONG).show();
            }

        }
        if (iFrequencia == 2) {
            sFrequencia = "Mensal";
            Toast.makeText(getApplicationContext(), editTextLembrete.getText().toString() + " " + sFrequencia + " dia " + String.valueOf(iDia), Toast.LENGTH_LONG).show();
        }
    }

    public void setItensDia() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i <= 27; i++) {
            lista.add(i, i + 1);
        }
        itensDia = lista;
    }

}