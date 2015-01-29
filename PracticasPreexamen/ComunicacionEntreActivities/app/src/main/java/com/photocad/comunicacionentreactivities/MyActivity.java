package com.photocad.comunicacionentreactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {

    private static final int RESULT_CODE_DO_MATH = 33;
    public static final String EXTRA_USER_NUMBER = "parametro";


    EditText numero;
    TextView respuestaDevuelta;
    Button calcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Variables
        numero = (EditText)findViewById(R.id.editText_Numero);
        respuestaDevuelta = (TextView)findViewById(R.id.textView_RespuestaDevuelta);
        calcular = (Button)findViewById(R.id.button_Calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Conseguir el numero del editText
                String userData= numero.getText().toString();
                int userNumber = Integer.parseInt(userData);

                //Crear la conexion entre clases
                Intent intent = new Intent(MyActivity.this,MathActivity.class);

                //Pasar el numero de una a la otra
                intent.putExtra(EXTRA_USER_NUMBER,userNumber);

                //Comenzar la actividad y codigo id a elegir
                startActivityForResult(intent, RESULT_CODE_DO_MATH);
            }
        });
    }

    // Metodo Magico para recoger resultados de vuelta
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data); //porque?

        switch (requestCode){

            case RESULT_CODE_DO_MATH:
                //Buscar el Extra por su identificador
                int respuesta = data.getIntExtra(MathActivity.EXTRA_ANSWER,0);

                //Mostrarlo por pantalla
                TextView textViewRespuesta = (TextView) findViewById(R.id.textView_RespuestaDevuelta);
                textViewRespuesta.setText(""+respuesta);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
