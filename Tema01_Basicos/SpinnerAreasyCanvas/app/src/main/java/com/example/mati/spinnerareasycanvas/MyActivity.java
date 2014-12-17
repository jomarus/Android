package com.example.mati.spinnerareasycanvas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MyActivity extends Activity {

    Spinner sp;
    TextView tvB, tvA, tvR, tvResu;
    EditText etB, etA, etR;
    Button btCalc;

    String radio, resu, base, altura;
    Double numRadio, areaCirculo, numBase, numAltura, areaRectangulo, areaTriangulo;

    final static String areas[] = {"Rectangulo", "Circulo", "Triangulo"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        sp = (Spinner)findViewById(R.id.spAreas);
        tvR = (TextView) findViewById(R.id.tvRadio);
        tvB = (TextView) findViewById(R.id.tvBase);
        tvA = (TextView) findViewById(R.id.tvAltura);
        tvResu = (TextView) findViewById(R.id.tvResultado);
        etB = (EditText)findViewById(R.id.etBase);
        etA = (EditText)findViewById(R.id.etAltura);
        etR = (EditText)findViewById(R.id.etRadio);
        btCalc = (Button)findViewById(R.id.btCalcular);


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, areas);
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(adaptador);
        //hace invisible todos los tv y et hasta que les toca calcular el area
        invisible();

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (areas[position]=="Circulo") {
                    introducirDatosCirculo();
                }
                if (areas[position]=="Rectangulo") {
                    introducirDatosRectangulo();
                }
                if (areas[position]=="Triangulo") {
                    introducirDatosTriangulo();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void calcular (View view){

        radio = etR.getText().toString();
        base = etB.getText().toString();
        altura = etA.getText().toString();

        //Elegimos el item del Spinner!!!
        String selec =         sp.getSelectedItem().toString();

        if (selec.equals("Circulo")) {
            numRadio = Double.valueOf(Integer.parseInt(radio));
            areaCirculo = Math.PI*(numRadio*numRadio);
            resu = String.valueOf(areaCirculo);
            tvResu.setText("El area del Circulo es: "+resu);
        } else
        if (selec.equals("Rectangulo")) {
            numBase = Double.valueOf(Integer.parseInt(base));
            numAltura = Double.valueOf(Integer.parseInt(altura));
            areaRectangulo = numBase*numAltura;
            resu = String.valueOf(areaRectangulo);
            tvResu.setText("El area del Rectangulo es: "+resu);
        }
        else
        if (selec.equals("Triangulo")) {
            numBase = Double.valueOf(Integer.parseInt(base));
            numAltura = Double.valueOf(Integer.parseInt(altura));
            areaTriangulo = (numBase*numAltura)/2;
            resu = String.valueOf(areaTriangulo);
            tvResu.setText("El area del Triangulo es: "+resu);

        }
    }


    public void introducirDatosCirculo(){

        tvB.setVisibility(View.INVISIBLE);
        tvR.setVisibility(View.INVISIBLE);
        etA.setVisibility(View.INVISIBLE);
        tvA.setVisibility(View.INVISIBLE);
        etB.setVisibility(View.INVISIBLE);

        tvR.setVisibility(View.VISIBLE);
        tvResu.setVisibility(View.VISIBLE);
        etR.setVisibility(View.VISIBLE);
    }
    public void introducirDatosRectangulo(){

        tvR.setVisibility(View.INVISIBLE);
        etR.setVisibility(View.INVISIBLE);

        tvB.setVisibility(View.VISIBLE);
        tvA.setVisibility(View.VISIBLE);
        tvResu.setVisibility(View.VISIBLE);
        etB.setVisibility(View.VISIBLE);
        etA.setVisibility(View.VISIBLE);

    }
    public void introducirDatosTriangulo(){

        tvR.setVisibility(View.INVISIBLE);
        etR.setVisibility(View.INVISIBLE);

        tvB.setVisibility(View.VISIBLE);
        tvA.setVisibility(View.VISIBLE);
        tvResu.setVisibility(View.VISIBLE);
        etB.setVisibility(View.VISIBLE);
        etA.setVisibility(View.VISIBLE);

    }
    public void invisible(){

        tvA.setVisibility(View.INVISIBLE);
        tvB.setVisibility(View.INVISIBLE);
        tvR.setVisibility(View.INVISIBLE);
        tvResu.setVisibility(View.INVISIBLE);
        etA.setVisibility(View.INVISIBLE);
        etB.setVisibility(View.INVISIBLE);
        etR.setVisibility(View.INVISIBLE);

    }


}
