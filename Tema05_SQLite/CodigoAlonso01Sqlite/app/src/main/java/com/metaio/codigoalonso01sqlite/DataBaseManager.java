package com.metaio.codigoalonso01sqlite;

/**
 * Created by Peep on 08/01/2015.
 */
public class DataBaseManager {

    public static final String TABLE_NAME = "contactos";

    public static final String CN_ID = "_id"; //cn= column name
    public static final String CN_NAME = "nombre";
    public static final String CN_PHONE = "telefono";

    //IMPORTANTE dejar espacios entre las Strings de la query SQL

    public static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("
            + CN_ID + " integer primary key autoincrement, "
            + CN_NAME + " text not null,"
            + CN_PHONE + " text);";



}
