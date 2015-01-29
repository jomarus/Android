package com.example.mati.jmartinez_examen_2eva;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private List<Zona> zonas = new ArrayList<Zona>();

    CheckBox conRegalo;
    CheckBox conTarjeta;
    EditText peso;
    TextView titulo;
    RadioButton tNormal, tUrgente;
    RadioGroup rg;
    Button enviar;
    Intent intentResultado = new Intent(this, Resultado.class);
    private DataBaseManager manager;

    Zona clickedZona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conRegalo = (CheckBox) findViewById(R.id.checkBox);
        conTarjeta = (CheckBox) findViewById(R.id.checkBox2);

        peso = (EditText) findViewById(R.id.editText);
        titulo = (TextView) findViewById(R.id.textView);
        tNormal = (RadioButton) findViewById(R.id.radioButton);
        tUrgente = (RadioButton) findViewById(R.id.radioButton2);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        enviar = (Button) findViewById(R.id.button);


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nombre=clickedZona.getNombre();
               int precio=clickedZona.getPrecio();

                Bundle mBundle = new Bundle();
                mBundle.putString("nombre", nombre);

                mBundle.putInt("precio", precio);
                intentResultado.putExtras(mBundle);

                startActivity(intentResultado);

            }
        });
        //populateCarList();
        //populateListView();
        //registerClickCallback();
    }

    private void populateCarList() {
        zonas.add(new Zona("ZonaA", 30, R.drawable.asia_oceania,"Oceania"));
        zonas.add(new Zona("ZonaB", 20, R.drawable.america_africa,"Africa"));
        zonas.add(new Zona("ZonaC", 10, R.drawable.europa,"Europa"));
    }

    private void populateListView() {

        ArrayAdapter<Zona> adapter = new MyListAdapter();
        ListView list = (ListView)findViewById(R.id.listViewCars);
        list.setAdapter(adapter);

        //Spinner spi = (Spinner)findViewById(R.id.spinner);
        //spi.setAdapter(adapter);

    }

    //Lanzar un mensaje por pantalla
    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listViewCars);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                clickedZona = zonas.get(position);
                String mensaje = "Has pulsado la posicion " + position +
                        " Que envia el paquete a la " + clickedZona.getZona();
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<Zona> {
        public MyListAdapter(){
            //Constructor: Clase Super, Clase Plantilla de cada elemento, lista de objetos
            super(MainActivity.this, R.layout.item_view, zonas);
        }
        //boton derecho generar/override methods/getView
        @Override

        //Posicion en la lista, vista para inflar
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView = convertView;
            if(itemView == null){
                //Rellenar la lista con cada elemento
                itemView = getLayoutInflater().inflate(R.layout.item_view,parent,false);
            }

            //Encontrar el zona con la que trabajar
            Zona currentZona = zonas.get(position);

            //Rellenar la vista
            ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentZona.getIconID());

            //ZOna
            TextView makeText = (TextView) itemView.findViewById(R.id.zona);
            makeText.setText(currentZona.getZona());

            //Precio
            TextView yearText = (TextView) itemView.findViewById(R.id.precio);
            yearText.setText("" + currentZona.getPrecio());

            //NombreZona
            TextView conditionText = (TextView) itemView.findViewById(R.id.nombre);
            conditionText.setText(currentZona.getNombre());


            return itemView;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                Intent intent = new Intent(this, PantallaCustomDibujos.class);

                startActivity(intent);
                return true;
            case R.id.MnuOpc2:
                startActivity(intentResultado);
                manager = new DataBaseManager(this);
                manager.insertar(nombre,precio);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
