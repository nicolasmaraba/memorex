package memorex.progrid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.LinearLayout;

import memorex.progrid.memorex.R;

public class CalendarioActivity extends ActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        //UTILIZE ESTA LINHA PARA IMPORTAR O XML DE INTERFACE E INCLUIR NA INTERFACE BASE
        LinearLayout linear = (LinearLayout) View.inflate(this,
                R.layout.activity_calendario, null);
        base.addView(linear, new ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT));


    }
}
