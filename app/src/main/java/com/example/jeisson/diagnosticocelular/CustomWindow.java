package com.example.jeisson.diagnosticocelular;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jeisson on 25/06/16.
 */
public class CustomWindow extends Activity {
    protected TextView title;
    protected ImageView icon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

        setContentView(R.layout.activity_pantalla_inicio);

        this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titulos);

        title = (TextView) findViewById(R.id.title);
        icon  = (ImageView) findViewById(R.id.icon);
    }
}
