package com.metaio.codigoalonso01sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Objeto helper
        DbHelper helper = new DbHelper(this);

        //Crear base de datos
        SQLiteDatabase db = helper.getWritableDatabase();


    }
}
