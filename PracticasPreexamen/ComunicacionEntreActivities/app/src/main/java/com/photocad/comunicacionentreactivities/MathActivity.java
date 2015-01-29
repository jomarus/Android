package com.photocad.comunicacionentreactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MathActivity extends Activity {

    public static final String EXTRA_ANSWER = "resultado";
    TextView respuesta;
    int valueToWorkWith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity2);

        //Recoger el intent de la clase main y buscar el parametro
        Intent intent = getIntent();
        valueToWorkWith = intent.getIntExtra(MyActivity.EXTRA_USER_NUMBER,0);

        //Mostrar parametro por pantalla
        respuesta = (TextView)findViewById(R.id.textView_Respuesta);
        respuesta.setText(""+valueToWorkWith); //convertir char[] a string con ""+

        setupDoubleButton();
    }


    private void setupDoubleButton() {
        Button btn = (Button) findViewById(R.id.button_Duplicar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calcular la respuesta
                int resultado = valueToWorkWith*2;

                //Devolver el valor
                Intent intent = new Intent();

                //"resultado" identifica el objeto Extra
                intent.putExtra(EXTRA_ANSWER,resultado);

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
        getMenuInflater().inflate(R.menu.my_activity2, menu);
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
