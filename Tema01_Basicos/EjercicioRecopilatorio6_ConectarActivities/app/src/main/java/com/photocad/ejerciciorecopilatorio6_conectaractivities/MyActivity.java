package com.photocad.ejerciciorecopilatorio6_conectaractivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {

    public static final int COD_RESPUESTA2 = 2; //como una señal de que se ha producido la comunicacion
    public static final int COD_RESPUESTA3 = 3; //como una señal de que se ha producido la comunicacion

    TextView pantalla;
    Button boton_irA2, boton_irA3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        pantalla=(TextView)findViewById(R.id.textView);
        boton_irA2=(Button)findViewById(R.id.button_Activity2);
        boton_irA3=(Button)findViewById(R.id.button_Activity3);

        boton_irA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct2 = new Intent(MyActivity.this,MyActivity2.class);
                //startActivity(intentAct2);
                startActivityForResult(intentAct2,COD_RESPUESTA2);
            }
        });

        boton_irA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct3 = new Intent(MyActivity.this,MyActivity3.class);
                startActivityForResult(intentAct3,COD_RESPUESTA3);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case COD_RESPUESTA2:
                pantalla.setText("Volviendo de la pantalla2");
                break;

            case COD_RESPUESTA3:
                pantalla.setText("Volviendo de la pantalla3");
                break;
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
