package com.example.mati.jmartinez_examen_2eva;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Resultado extends ActionBarActivity {

    TextView zonaText,pesoText,precioText,tarjetaText,regaloText,tarifaText;

    int peso,tarifa,precio;
    boolean tarjeta,regalo;
    String zona,tarjetaTexto,regaloTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        zonaText = (TextView) findViewById(R.id.textViewZona);
        pesoText = (TextView) findViewById(R.id.textViewPeso);
        precioText = (TextView) findViewById(R.id.textViewPrecio);
        tarjetaText = (TextView) findViewById(R.id.textViewTarjeta);
        regaloText = (TextView) findViewById(R.id.textViewRegalo);
        tarifaText = (TextView) findViewById(R.id.textViewtarifa);

        zona = getIntent().getExtras().getString("nombreZona");
        peso = getIntent().getExtras().getInt("peso");
        precio = getIntent().getExtras().getInt("precio");
        tarjeta = getIntent().getExtras().getBoolean("tarjeta");
        regalo = getIntent().getExtras().getBoolean("regalo");
        tarifa = getIntent().getExtras().getInt("tarifa");


        if(tarjeta==true) {
             tarjetaTexto = "si";
        }else{
             tarjetaTexto = "no";
        }
        if(regalo==true) {
             regaloTexto = "si";
        }else{
             regaloTexto = "no";
        }

        String pesoTexto=Integer.toString(peso);
        String precioTexto=Integer.toString(precio);
        String tarifaTexto=Integer.toString(tarifa);

        zonaText.setText(zona);
        pesoText.setText(pesoTexto);
        precioText.setText(precioTexto);
        tarjetaText.setText(tarjetaTexto);
        regaloText.setText(regaloTexto);
        tarifaText.setText(tarifaTexto);
    }
}
