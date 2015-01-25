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
        db.insert(TABLE_NAME,null,generarContentValues(nombre, telefono));
    }
    //Esta operacion se repite mucho, por eso creo el metodo generarContentValues
    private ContentValues generarContentValues(String nombre, String telefono){
        ContentValues valores = new ContentValues();
        valores.put(CN_NAME, nombre);
        valores.put(CN_PHONE, telefono);
        return valores;
    }
    //INSERTAR 2
    public void insertar2(String nombre, String telefono){
        //INSERT INTO contactos VALUES (null,'paco',9999)
        db.execSQL("insert into "+TABLE_NAME+" values (null,'"+nombre+"',"+telefono+")");
    }

    //DELETE
    public void eliminar(String nombre){
        //bd.delete(Tabla, Clausula Where, Argumentos Where)
        db.delete(TABLE_NAME, CN_NAME + "=?",new String[]{nombre});//vector de strings para poder eliminar varios a la vez
    }
    public void eliminarMultiple(String nom1,String nom2){
        //bd.delete(Tabla, Clausula Where, Argumentos Where)
        db.delete(TABLE_NAME, CN_NAME + "IN (?,?)",new String[]{nom1, nom2});
    }

    //UPDATE
    public void modificarTelefono(String nombre, String nuevoTelefono){
        //bd.update(TABLA, ContentValues, Clausula Where, Argumentos Where)
        db.update(TABLE_NAME,generarContentValues(nombre,nuevoTelefono),CN_NAME + "=?",new String[]{nombre});
    }


    //RECORRER BASE DE DATOS
    public Cursor cargarCursorContactos(){
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_PHONE};
        //query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
        return db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }

    //BUSCAR UN CONTACTO
    public Cursor buscarContacto(String nombre){
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_PHONE};
        return db.query(TABLE_NAME,columnas,CN_NAME + "=?",new String[]{nombre},null,null,null);//? se sustetuye por el String[]{nombre}
    }


}
