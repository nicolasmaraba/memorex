package memorex.progrid.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import memorex.progrid.base.Common;
import memorex.progrid.memorex.R;

/**
 * Created by progrid on 19/10/17.
 */
public class ActivityBase extends AppCompatActivity {

    protected FrameLayout base;
    protected Common common;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_base);

        common = (Common)getApplicationContext();

        base = (FrameLayout) findViewById(R.id.base);

    }
}
