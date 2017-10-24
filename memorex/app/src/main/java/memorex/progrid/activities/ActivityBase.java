package memorex.progrid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import memorex.progrid.base.Common;
import memorex.progrid.memorex2.R;

public class ActivityBase extends AppCompatActivity {

    protected FrameLayout base;
    protected Common common;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        common = (Common)getApplicationContext();

        base = (FrameLayout) findViewById(R.id.base);
    }
}
