package com.example.mati.jmartinez_examen_2eva;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Resultado extends ActionBarActivity {


    TextView precioText;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        precioText = (TextView) findViewById(R.id.precio);

        value = getIntent().getExtras().getInt("precio");
        String precioTexto=Integer.toString(value);

        precioText.setText(precioTexto);
    }
}
