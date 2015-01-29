package com.example.mati.jmartinez_examen_2eva;

/**
 * Created by mati on 29/01/15.
 */
public class Paquete {

    String nombreZona;
    String zona;
    String precio;


    public Paquete(String nombreZona, String zona, String precio){
        this.nombreZona=nombreZona;
        this.zona=zona;
        this.precio=precio;

    }

    public String getNombreZona(){
        return nombreZona;
    }

    public String getZona(){
        return zona;
    }

    public String getPrecio(){
        return precio;
    }

}
