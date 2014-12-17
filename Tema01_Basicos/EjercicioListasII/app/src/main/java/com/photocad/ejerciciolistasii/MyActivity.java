package com.photocad.ejerciciolistasii;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends Activity {

    private List<Car> myCars = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        populateCarList();
        populateListView();
        registerClickCallback();
    }

    private void populateCarList() {
        myCars.add(new Car("Ford", 1940, R.drawable.a, "Needing Work"));
        myCars.add(new Car("Toyota", 1998, R.drawable.b, "japones"));
        myCars.add(new Car("Onda",1989,R.drawable.c,"No se de donde"));
        myCars.add(new Car("Porche",1978,R.drawable.d,"franchute"));
        myCars.add(new Car("Jeep",1999,R.drawable.e,"Americaner"));
        myCars.add(new Car("Cañonero",2000,R.drawable.f,"muy Americaner"));
        myCars.add(new Car("SeatPanda",2016,R.drawable.g,"elegancia"));

    }

    private void populateListView() {

        ArrayAdapter<Car> adapter = new MyListAdapter();
        ListView list = (ListView)findViewById(R.id.listViewCars);
        list.setAdapter(adapter);
    }

    //Lanzar un mensaje por pantalla
    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listViewCars);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Car clickedCar = myCars.get(position);
                String mensaje = "Has pulsado la posicion " + position +
                        "Que contiene el coche " + clickedCar.getMake();
                Toast.makeText(MyActivity.this, mensaje,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<Car> {
        public MyListAdapter(){
            //Constructor: Clase Super, Clase Plantilla de cada elemento, lista de objetos
            super(MyActivity.this, R.layout.item_view, myCars);
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

            //Encontrar el coche con el que trabajar
            Car currentCar = myCars.get(position);

            //Rellenar la vista
            ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentCar.getIconID());

            //Make
            TextView makeText = (TextView) itemView.findViewById(R.id.item_txtMake);
            makeText.setText(currentCar.getMake());

            //Year
            TextView yearText = (TextView) itemView.findViewById(R.id.item_txtYear);
            yearText.setText("" + currentCar.getIconID());

            //Condition
            TextView conditionText = (TextView) itemView.findViewById(R.id.item_txtCondition);
            conditionText.setText(currentCar.getCondition());

            return itemView;
        }
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
