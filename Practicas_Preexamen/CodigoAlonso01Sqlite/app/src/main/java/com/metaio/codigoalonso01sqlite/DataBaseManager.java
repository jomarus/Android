package com.metaio.codigoalonso01sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Peep on 08/01/2015.
 */
public class DataBaseManager {

    //VARIABLES
    public static final String TABLE_NAME = "contactos";

    public static final String CN_ID = "_id"; //cn= column name
    public static final String CN_NAME = "nombre";
    public static final String CN_PHONE = "telefono";

    //Variable estatica de creacion de la tabla, IMPORTANTE dejar espacios entre las Strings de la query SQL
    public static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("
            + CN_ID + " integer primary key autoincrement, "
            + CN_NAME + " text not null,"
            + CN_PHONE + " text);";

    private DbHelper helper;
    private SQLiteDatabase db;


    //CONSTRUCTOR
    public DataBaseManager(Context context) {

        //Objeto helper
        helper = new DbHelper(context);

        //Crear base de datos, DbHelper extiende SQLiteOpenHelper
        db = helper.getWritableDatabase();
    }

    //INSERTAR
    //bd.insert(TABLA, NullColumHack, ContentValues);
    public void insertar(String nombre, String telefono){
        ContentValues valores = new ContentValues();
        valores.put(CN_NAME, nombre);
        valores.put(CN_PHONE, telefono);
        db.insert(TABLE_NAME,null,valores);
    }
}
