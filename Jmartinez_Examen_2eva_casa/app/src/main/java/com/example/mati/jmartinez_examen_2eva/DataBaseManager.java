package com.example.mati.jmartinez_examen_2eva;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Peep on 29/01/2015.
 */
public class DataBaseManager {

    //VARIABLES
    public static final String TABLE_NAME = "envios";

    public static final String CN_ID = "_id"; //cn= column name
    public static final String CN_NAME = "nombre";
    public static final String CN_PRECIO = "precio";

    //Variable estatica de creacion de la tabla, IMPORTANTE dejar espacios entre las Strings de la query SQL
    public static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("
            + CN_ID + " integer primary key autoincrement, "
            + CN_NAME + " text not null,"
            + CN_PRECIO + " integer);";

    private Dbhelper helper;
    private SQLiteDatabase db;


    //CONSTRUCTOR
    public DataBaseManager(Context context) {

        //Objeto helper
        helper = new Dbhelper(context);

        //Crear base de datos, Dbhelper extiende SQLiteOpenHelper
        db = helper.getWritableDatabase();
    }

    //INSERTAR
    //bd.insert(TABLA, NullColumHack, ContentValues);
    public void insertar(String nombre, int precio){
        ContentValues valores = new ContentValues();
        valores.put(CN_NAME, nombre);
        valores.put(CN_PRECIO, precio);
        db.insert(TABLE_NAME,null,valores);
    }
}

