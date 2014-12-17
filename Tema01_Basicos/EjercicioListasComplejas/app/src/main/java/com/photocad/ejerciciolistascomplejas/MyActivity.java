package com.photocad.ejerciciolistascomplejas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends Activity {

    private List<Car> myCars = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        populateCarList();
    }

    private void populateCarList() {
        myCars.add(new Car("Ford",1940,R.drawable.a,"Needing Work"));
        myCars.add(new Car("Toyota",1998,R.drawable.b,"japones"));
        myCars.add(new Car("Onda",1989,R.drawable.c,"No se de donde"));
        myCars.add(new Car("Porche",1978,R.drawable.d,"franchute"));
        myCars.add(new Car("Jeep",1999,R.drawable.e,"Americaner"));
        myCars.add(new Car("Cañonero",2000,R.drawable.f,"muy Americaner"));
        myCars.add(new Car("SeatPanda",2016,R.drawable.g,"elegancia"));

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
