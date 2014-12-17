package com.photocad.ejerciciorecopilatorio4_togglebutton;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MyActivity extends Activity {

    TextView pantalla;
    ToggleButton botonRojo;
    ToggleButton botonAzul;
    ToggleButton botonVerde;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        pantalla=(TextView)findViewById(R.id.textView_Pantalla);
        botonRojo=(ToggleButton)findViewById(R.id.toggleButton_Rojo);
        botonAzul=(ToggleButton)findViewById(R.id.toggleButton_Azul);
        botonVerde=(ToggleButton)findViewById(R.id.toggleButton_Verde);


        botonRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botonRojo.isChecked()){
                    pantalla.setBackgroundColor(Color.RED);
                }else{
                    comprobar();
                }
            }
        });
        botonAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botonAzul.isChecked()){
                    pantalla.setBackgroundColor(Color.BLUE);
                }else{
                    comprobar();
                }
            }
        });
        botonVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botonVerde.isChecked()){
                    pantalla.setBackgroundColor(Color.GREEN);
                }else{
                    comprobar();
                }
            }
        });
    }

    public void comprobar() {
        if (botonAzul.isChecked() == false && botonRojo.isChecked() == false && botonVerde.isChecked() == false) {
            pantalla.setBackgroundColor(Color.BLACK);
        }
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
