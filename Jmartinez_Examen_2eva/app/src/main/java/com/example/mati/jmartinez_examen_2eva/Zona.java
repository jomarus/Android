package com.example.mati.jmartinez_examen_2eva;

/**
 * Created by mati on 29/01/15.
 */
public class Zona {

    private String zona;
    private int iconID;
    private int precio;
    private String nombre;

    public Zona(String zona, int precio, int iconID,String nombre){
        super();
        this.zona = zona;
        this.iconID = iconID;
        this.precio = precio;
        this.nombre = nombre;
    }


    public String getZona(){
        return zona;
    }
    public int getIconID(){
        return iconID;
    }
    public int getPrecio(){
        return precio;
    }
    public String getNombre(){
        return nombre;
    }

}
