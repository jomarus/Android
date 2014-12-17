package com.photocad.codigoalonsoholamundo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity01 extends Activity {

    //Declarar variables globales
    TextView respuesta;
    Button boton;
    FrameLayout marco;
    ImageView icono;

    int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Constructor
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //VARIABLES
        respuesta = (TextView)findViewById(R.id.textView_Respuesta);
        boton = (Button) findViewById(R.id.button_Boton);
        icono = (ImageView)findViewById(R.id.imageView);
        marco = (FrameLayout)findViewById(R.id.marco);

        //METODOS
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //Escribir numero
                numero++;
                respuesta.setText(String.valueOf(numero));
                respuesta.setBackgroundColor(Color.RED);

                //Acceder a un marco
                marco.setBackgroundColor(Color.RED);

                //Crear e Insertar nuevo objeto
                TextView TextoBotonero = new TextView(getApplicationContext());
                TextoBotonero.setText("caca");
                TextoBotonero.setTextColor(Color.BLUE);
                TextoBotonero.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
                marco.addView(TextoBotonero);

                //Acceder a otra activity
                Intent miIntent= new Intent(Activity01.this, Activity02.class);
                startActivity(miIntent);

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
