package com.metaio.codigoalonso01sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {//Alt+Intro --> implemertar metodos y contructor loco


    private static final String DB_NAME = "contactos.sqlite";
    private static final int DB_SCHEME_VERSION = 1;


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DataBaseManager.CREATE_TABLE);

    }

    @Override
    //actualiza la base de datos en funcion de la variable DB_SCHEME_VERSION
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
