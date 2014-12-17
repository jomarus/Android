package com.photocad.menusycanvas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {

    int flag;
    TextView lado1, lado2, lblMensaje;
    EditText editLado1, editLado2;
    Button botonAceptar;
    String longitudLado,longitudLado2;
    String[] formas;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Intent mIntent,mIntent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        lado1 = (TextView)findViewById(R.id.textViewLado1);
        lado2 = (TextView)findViewById(R.id.textViewLado2);
        editLado1 = (EditText)findViewById(R.id.editTextLado1);
        editLado2 = (EditText)findViewById(R.id.editTextLado2);
        lblMensaje = (TextView)findViewById(R.id.lblMensaje);
        botonAceptar=(Button)findViewById(R.id.buttonAceptar);
        spinner=(Spinner)findViewById(R.id.spinner);
        formas = getResources().getStringArray(R.array.formas); //para recoger el array del xml

        mIntent = new Intent(this, Dibujos.class);
        mIntent2 = new Intent(this, Trazos.class);

        final Bundle mBundle = new Bundle();


        lado1.setVisibility(View.INVISIBLE);
        lado2.setVisibility(View.INVISIBLE);
        editLado1.setVisibility(View.INVISIBLE);
        editLado2.setVisibility(View.INVISIBLE);
        spinner.setVisibility(View.INVISIBLE);
        botonAceptar.setVisibility(View.INVISIBLE);

        adapter =  ArrayAdapter.createFromResource(this,R.array.formas,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(formas[position].equals("Rectangulo")){
                    lado1.setText("Lado1");
                    lado1.setVisibility(View.VISIBLE);
                    lado2.setVisibility(View.VISIBLE);
                    editLado1.setVisibility(View.VISIBLE);
                    editLado2.setVisibility(View.VISIBLE);
                    flag=0;
                }else if(formas[position].equals("Circulo")){
                    lado1.setText("Radio");
                    lado1.setVisibility(View.VISIBLE);
                    lado2.setVisibility(View.INVISIBLE);
                    editLado1.setVisibility(View.VISIBLE);
                    editLado2.setVisibility(View.INVISIBLE);
                    flag=1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                longitudLado = editLado1.getText().toString();
                mBundle.putString("lado1", longitudLado);
                mIntent.putExtras(mBundle);

                //Opcion Rectangulo
                if(flag==0) {
                    longitudLado2=editLado2.getText().toString();
                }
                //Opcion Circulo
                else if(flag==1){
                    longitudLado2="-1";
                }

                mBundle.putString("lado2", longitudLado2);
                mIntent.putExtras(mBundle);

                startActivity(mIntent);
            }
        });
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje.setText("Calculo de areas");
                spinner.setVisibility(View.VISIBLE);
                botonAceptar.setVisibility(View.VISIBLE);

                return true;

            case R.id.MnuOpc2:
                lblMensaje.setText("Dibujo de trazos");
                startActivity(mIntent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
