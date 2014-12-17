package com.photocad.ejerciciorecopilatorio2_imagebuttons;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MyActivity extends Activity {

    ImageButton btRojo, btAzul;
    LinearLayout fondo;//he utilizado directamente el fondo de la pantalla para cambiar el color del fondo completo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        btAzul=(ImageButton)findViewById(R.id.imageButton_Azul);
        btRojo=(ImageButton)findViewById(R.id.imageButton_Rojo);
        fondo=(LinearLayout)findViewById(R.id.fondo);


        btAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fondo.setBackgroundColor(Color.BLUE);
            }
        });

        btRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fondo.setBackgroundColor(Color.RED);
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
