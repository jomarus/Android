package com.pruebas.spinnerlistas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private String[] colores= new String[]{"Rojo","Verde","Azul","Amarillo"};

    Button boton;
    ListView lista;
    Spinner spinner;
    ArrayAdapter<String> adapter;
    ArrayAdapter<CharSequence> adapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VARIABLES
        boton=(Button)findViewById(R.id.button);
        lista=(ListView)findViewById(R.id.listView);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,colores);

        //CONFIGURAR LISTA
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Has seleccionado "+colores[position],Toast.LENGTH_SHORT).show();
            }
        });

        //CONFIGURAR SPINNER
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Has seleccionado "+colores[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Nada",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
