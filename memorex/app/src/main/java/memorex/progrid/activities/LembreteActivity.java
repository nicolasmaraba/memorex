package memorex.progrid.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.MaskFilter;
import android.os.Bundle;
import android.text.style.MaskFilterSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.DataTruncation;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    private SimpleDateFormat formatoData;
    int year_x,month_x,day_x;
    static final int DIALOG_ID = 0;


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
        final Button btnCalendario = (Button) findViewById(R.id.btnCalendario);
        formatoData = new SimpleDateFormat("dd/MM/yyyy");
        formatoData.setLenient(false);



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
        btnCalendario.setVisibility(View.GONE);
        // Implementação do botão do calendário
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x  = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                showDialog(DIALOG_ID);
            }
        });



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
                    btnCalendario.setVisibility(View.GONE);
                }
                if (iFrequencia == 1) {
                    spinnerDia.setVisibility(View.GONE);
                    textViewDia.setVisibility(View.GONE);
                    textViewData.setVisibility(View.VISIBLE);
                    editTextData.setVisibility(View.VISIBLE);
                    btnCalendario.setVisibility(View.VISIBLE);
                }
                if (iFrequencia == 0) {
                    spinnerDia.setVisibility(View.GONE);
                    textViewDia.setVisibility(View.GONE);
                    textViewData.setVisibility(View.GONE);
                    editTextData.setVisibility(View.GONE);
                    btnCalendario.setVisibility(View.GONE);
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
        Boolean bDataValida = false;

        if (iFrequencia == 1) {
            sFrequencia = "Eventual";
            if (validaData(editTextData.getText().toString())) {
                Toast.makeText(getApplicationContext(), editTextLembrete.getText().toString() + " " + sFrequencia + " dia " + editTextData.getText().toString(), Toast.LENGTH_LONG).show();
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
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListner, year_x, month_x, day_x);
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerListner
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear +1;
            day_x = dayOfMonth;
            String sMes= "" + month_x;
            String sDia ="" + day_x;
            if(month_x<10){
                sMes = "0"+month_x;
            }
            if (day_x< 10){
                sDia = "0"+day_x;
            }
            editTextData.setText( sDia+ "/" + sMes + "/" + year_x);
        }
    };

    private boolean validaData(String sData){
        String sMensagemErro = "";
        boolean  bResultado = false;
        try {
            Date date = formatoData.parse(sData);
            Date dataAtual =new Date();

            if (date.getTime() <= dataAtual.getTime()){
                sMensagemErro = "A data deverá ser maior que a data atual";
            }else {
                if ((date.getTime() - dataAtual.getTime()) / (1000 * 60 * 60 * 24) >= 365 ) {
                    sMensagemErro = "A data do evento não pode ser posterior a um ano";
                }else{
                    bResultado= true;
                }

            }
        } catch (ParseException e) {
            sMensagemErro = "Data inválida";
        }
        if (sMensagemErro !=""){
            Toast.makeText(getApplicationContext(), sMensagemErro, Toast.LENGTH_LONG).show();
        }

        return bResultado;
    }

}