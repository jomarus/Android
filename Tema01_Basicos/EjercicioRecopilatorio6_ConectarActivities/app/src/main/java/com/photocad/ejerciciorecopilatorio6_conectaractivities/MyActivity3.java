package com.photocad.ejerciciorecopilatorio6_conectaractivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MyActivity3 extends Activity {

    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity3);

        volver=(Button)findViewById(R.id.button_volverA1desdeA3);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Devolver el valor
                Intent intent = new Intent();

                //Parametro resultCode del metodo onActivityResult en la clase main
                //RESULT_OK porque si
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity3, menu);
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
