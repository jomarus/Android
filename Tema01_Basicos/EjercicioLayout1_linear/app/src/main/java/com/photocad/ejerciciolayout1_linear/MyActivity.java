package com.photocad.ejerciciolayout1_linear;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.photocad.ejerciciolayout1_linear.R.id.radioGroup;

public class MyActivity extends Activity {

    TextView pantalla;
    Button ponerColor, borrar;
    RadioGroup rg;
    RadioButton rbred,rbwhite,rbblue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ponerColor = (Button)findViewById(R.id.buttonPonerColor);
        borrar = (Button)findViewById(R.id.buttonBorrar);

        pantalla = (TextView)findViewById(R.id.textViewPantalla);
        rg = (RadioGroup)findViewById(radioGroup);
        rbred = (RadioButton)findViewById(R.id.radioButtonRed);
        rbwhite = (RadioButton)findViewById(R.id.radioButtonWhite);
        rbblue = (RadioButton)findViewById(R.id.radioButtonBlue);

        rg.check(R.id.radioButtonBlue);

        ponerColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbred.isChecked()){
                    pantalla.setBackgroundColor(Color.RED);
                }
                if(rbwhite.isChecked()){
                    pantalla.setBackgroundColor(Color.WHITE);
                }
                if(rbblue.isChecked()){
                    pantalla.setBackgroundColor(Color.BLUE);
                }
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantalla.setBackgroundColor(Color.WHITE);
                rg.clearCheck();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
