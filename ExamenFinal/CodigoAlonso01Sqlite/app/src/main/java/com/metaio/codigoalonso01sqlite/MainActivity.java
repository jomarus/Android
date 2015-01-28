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
    private EditText tv;
    private ImageButton bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (EditText) findViewById(R.id.editText);
        bt = (ImageButton) findViewById(R.id.imageButton);

        //Crear objeto de la DB
        manager = new DataBaseManager(this);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SQL INSERT
                String nombre=tv.getText().toString();
                manager.insertar(nombre,"1111111");
            }
        });

    }

}
