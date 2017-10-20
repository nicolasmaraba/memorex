package memorex.progrid.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import memorex.progrid.memorex.R;

/**
 * Created by progrid on 19/10/17.
 */
public class ItemActivity extends ActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linear = (LinearLayout) View.inflate(this,
                R.layout.activity_item, null);
        base.addView(linear, new ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT));
    }

}
