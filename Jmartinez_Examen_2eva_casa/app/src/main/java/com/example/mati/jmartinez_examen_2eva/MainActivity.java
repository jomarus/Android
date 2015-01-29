package com.example.mati.jmartinez_examen_2eva;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
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
    EditText pesoText;
    TextView titulo;
    RadioButton tNormal, tUrgente;
    RadioGroup rg;
    Button enviar;
    Intent intent;
    Zona clickedZona;

    int peso,tarifa,precio,precioFinal;
    boolean tarjeta,regalo;
    String nombreZona;
    Bundle mBundle;


    //VARIABLES SPINNER
    String[] strings = {"Zona A","Zona B","Zona C"};
    String[] precios = {"30","20","10"};
    String[] subs = {"Oceania Asia","Africa America","Europa"};
    TextView label;
    TextView continente;
    TextView preciosTV;
    int arr_images[] = { R.drawable.asia_oceania, R.drawable.america_africa, R.drawable.europa};

    Button button;
    TextView textview;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conRegalo = (CheckBox) findViewById(R.id.checkBox);
        conTarjeta = (CheckBox) findViewById(R.id.checkBox2);
        pesoText = (EditText) findViewById(R.id.editText);
        titulo = (TextView) findViewById(R.id.textView);
        tNormal = (RadioButton) findViewById(R.id.radioButton);
        tUrgente = (RadioButton) findViewById(R.id.radioButton2);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        enviar = (Button) findViewById(R.id.button);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(tNormal.isChecked()){
                    tarifa=0;
                }
                if(tUrgente.isChecked()){
                    tarifa=30;
                }
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultadoConSpinner();
                intent = new Intent(getBaseContext(), Resultado.class);
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });

        populateList();
        populateListView();
        registerClickCallback();
    }

    private void calcularResultado(){
        nombreZona=clickedZona.getNombre();
        peso=Integer.parseInt(pesoText.getText() + "");
        precio=clickedZona.getPrecio();
        precioFinal=precio+(precio*tarifa/100)*peso;

        if(conTarjeta.isChecked()){
            regalo=true;
        }
        if(conRegalo.isChecked()){
            tarjeta=true;
        }
        mBundle=new Bundle();
        mBundle.putString("nombreZona", nombreZona);
        mBundle.putInt("peso", peso);
        mBundle.putInt("precio", precioFinal);
        mBundle.putBoolean("tarjeta", tarjeta);
        mBundle.putBoolean("regalo", regalo);
        mBundle.putInt("tarifa", tarifa);
    }

    private void calcularResultadoConSpinner(){

        nombreZona= continente.getText()+"";
        peso=Integer.parseInt(pesoText.getText() + "");
        precio=Integer.parseInt(preciosTV.getText() + "");
        precioFinal=precio+(precio*tarifa/100)*peso;

        if(conTarjeta.isChecked()){
            regalo=true;
        }
        if(conRegalo.isChecked()){
            tarjeta=true;
        }
        mBundle=new Bundle();
        mBundle.putString("nombreZona", nombreZona);
        mBundle.putInt("peso", peso);
        mBundle.putInt("precio", precioFinal);
        mBundle.putBoolean("tarjeta", tarjeta);
        mBundle.putBoolean("regalo", regalo);
        mBundle.putInt("tarifa", tarifa);
    }



    private void populateList() {
        zonas.add(new Zona("ZonaA", 30, R.drawable.asia_oceania,"Oceania"));
        zonas.add(new Zona("ZonaB", 20, R.drawable.america_africa,"Africa"));
        zonas.add(new Zona("ZonaC", 10, R.drawable.europa,"Europa"));
    }

    private void populateListView() {

        ArrayAdapter<Zona> adapter = new MyListAdapter();
        ListView list = (ListView)findViewById(R.id.listViewCars);
        list.setAdapter(adapter);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(new AdapterSpinner(this, R.layout.row, strings));

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
            TextView yearText = (TextView) itemView.findViewById(R.id.textViewPrecio);
            yearText.setText("" + currentZona.getPrecio());

            //NombreZona
            TextView conditionText = (TextView) itemView.findViewById(R.id.nombre);
            conditionText.setText(currentZona.getNombre());


            return itemView;
        }
    }

    private class AdapterSpinner extends ArrayAdapter<String>{

        public AdapterSpinner(Context context, int textViewResourceId, String[] objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View convertView,ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.row, parent, false);

            label=(TextView)row.findViewById(R.id.company);
            label.setText(strings[position]);

            continente =(TextView)row.findViewById(R.id.sub);
            continente.setText(subs[position]);

            preciosTV=(TextView)row.findViewById(R.id.precio);
            preciosTV.setText(precios[position]);

            ImageView icon=(ImageView)row.findViewById(R.id.image);
            icon.setImageResource(arr_images[position]);
            return row;
        }
    }

    private DataBaseManager manager;
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
                intent = new Intent(this, PantallaCustomDibujos.class);
                startActivity(intent);
                return true;
            case R.id.MnuOpc2:
                manager = new DataBaseManager(this);
                calcularResultado();

                manager.insertar(nombreZona,precioFinal);
                Toast.makeText(MainActivity.this, "Insertados los calculos del envio a la zona"+nombreZona+" con precio: "+precioFinal, Toast.LENGTH_SHORT).show();

                intent = new Intent(getBaseContext(), Resultado.class);
                intent.putExtras(mBundle);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
