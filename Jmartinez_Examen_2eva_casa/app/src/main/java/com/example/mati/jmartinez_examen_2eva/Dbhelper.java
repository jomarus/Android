package com.example.mati.jmartinez_examen_2eva;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Peep on 29/01/2015.
 */
public class Dbhelper extends SQLiteOpenHelper {//Alt+Intro --> implemertar metodos y contructor loco


    private static final String DB_NAME = "envios.sqlite";
    private static final int DB_SCHEME_VERSION = 1;


    public Dbhelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    //Crea la tabla con la variable de la clase DataBaseManager
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManager.CREATE_TABLE);
    }

    @Override
    //Actualiza la base de datos en funcion de la variable DB_SCHEME_VERSION
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
