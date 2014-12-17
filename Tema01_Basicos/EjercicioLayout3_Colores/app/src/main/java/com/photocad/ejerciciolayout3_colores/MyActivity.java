package com.photocad.ejerciciolayout3_colores;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {


    TextView pantalla;
    Button botonRojo,botonAmarillo,botonAzul,botonBorrar;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Acceder a los recursos del XML colors, strings...
        res = getResources();

        pantalla = (TextView)findViewById(R.id.textView_Pantalla);
        botonRojo = (Button)findViewById(R.id.buttonRojo);
        botonAmarillo = (Button)findViewById(R.id.buttonAmarillo);
        botonAzul = (Button)findViewById(R.id.buttonAzul);
        botonBorrar = (Button)findViewById(R.id.buttonBorrar);

        botonRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantalla.setBackgroundColor(res.getColor(R.color.rojo));
            }
        });

        botonAmarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantalla.setBackgroundColor(res.getColor(R.color.amarillo));
            }
        });

        botonAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantalla.setBackgroundColor(res.getColor(R.color.Azul));
            }
        });

        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantalla.setBackgroundColor(res.getColor(R.color.Fondo));
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
