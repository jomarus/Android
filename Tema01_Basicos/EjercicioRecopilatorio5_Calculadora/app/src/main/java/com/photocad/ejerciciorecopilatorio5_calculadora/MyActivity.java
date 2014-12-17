package com.photocad.ejerciciorecopilatorio5_calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MyActivity extends Activity {


    EditText numeros;
    TextView respuesta;
    RadioButton sumar, restar;
    RadioGroup rg;
    double num,numRespuesta,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        numeros=(EditText)findViewById(R.id.editText_numero);
        respuesta=(TextView)findViewById(R.id.textView_Respuesta);
        sumar=(RadioButton)findViewById(R.id.radioButton_Sumar);
        restar=(RadioButton)findViewById(R.id.radioButton_Restar);
        rg=(RadioGroup)findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                num=Double.parseDouble(numeros.getText().toString());
                numRespuesta=Double.parseDouble(respuesta.getText().toString());

                if(sumar.isChecked()){
                    resultado=numRespuesta+num;
                    respuesta.setText(""+resultado);//convertir a string con el truc de las ""
                }
                if(restar.isChecked()){
                    resultado=numRespuesta-num;
                    respuesta.setText(""+resultado);
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
