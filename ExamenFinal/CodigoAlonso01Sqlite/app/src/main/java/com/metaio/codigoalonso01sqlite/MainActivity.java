package com.metaio.codigoalonso01sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private DataBaseManager manager;
    private Cursor cursor;
    private ListView lista;
    private SimpleCursorAdapter adapter;
    private EditText tv;
    private ImageButton bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listView);
        tv = (EditText) findViewById(R.id.editText);
        bt = (ImageButton) findViewById(R.id.imageButton);

        //Crear objeto de la DB
        manager = new DataBaseManager(this);

        /*Metodos CRUD

        manager.eliminar("Pepe");
        manager.eliminar("Juan");
        manager.eliminar("Ana");

        manager.insertar("Pepe","1111111");
        manager.insertar2("Juan","2222222222");
        manager.insertar("Ana","3333333");

        manager.modificarTelefono("Juan","4444444");
        */

        //Variables que pasan valores del cursor(+- fetch_row) a la listView
        String[] from = new String[]{manager.CN_NAME, manager.CN_PHONE};
        int[] to = new int[]{android.R.id.text1,android.R.id.text2};

        //Cargar cursor y montar lista con el adaptador por defecto
        cursor = manager.cargarCursorContactos();
        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to,0);
        lista.setAdapter(adapter);

        //BOTON
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BuscarTask().execute();
            }
        });
    }
    //CLASE PARA TRABAJAR EN SEGUNDO PLANO
    private class BuscarTask extends AsyncTask<Void,Void,Void> {

        // Se ejecuta en el hilo principal
        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(),"Buscando...",Toast.LENGTH_SHORT).show();
        }

        //Se ejecuta en segundo plano
        @Override
        protected Void doInBackground(Void... params) {
            cursor= manager.buscarContacto(tv.getText().toString());
            return null;
        }

        //Se ejecuta en segundo plano
        @Override
        protected void onPostExecute(Void aVoid) {
            adapter.changeCursor(cursor);
            Toast.makeText(getApplicationContext(),"Finalizada...",Toast.LENGTH_SHORT).show();
        }


    }
}
