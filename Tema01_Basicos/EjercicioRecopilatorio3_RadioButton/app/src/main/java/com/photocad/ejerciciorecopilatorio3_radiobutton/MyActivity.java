package com.photocad.ejerciciorecopilatorio3_radiobutton;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MyActivity extends Activity {

    TextView pantalla;
    RadioGroup rg;
    RadioButton rbred,rbgreen,rbblue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        pantalla = (TextView)findViewById(R.id.textViewPantalla);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        rbred = (RadioButton)findViewById(R.id.radioButtonRed);
        rbgreen = (RadioButton)findViewById(R.id.radioButtonGreen);
        rbblue = (RadioButton)findViewById(R.id.radioButtonBlue);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rbred.isChecked()){
                    pantalla.setBackgroundColor(Color.RED);
                }
                if(rbgreen.isChecked()){
                    pantalla.setBackgroundColor(Color.GREEN);
                }
                if(rbblue.isChecked()){
                    pantalla.setBackgroundColor(Color.BLUE);
                }
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
