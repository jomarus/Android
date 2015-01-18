
package socketentradas_ServidorJframe;

import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.JTextArea;

public class Entradas {

    String respuesta;
    private int lat1=4,lat2=4;
    private int vip1=3,vip2=3;
    private int gal=8;
    private int cen=54;
    private int entradas;
    
    
    public Entradas() {
    }

    public void reservaEntradas(String mensaje,JTextArea chatView,PrintWriter out){
        
        
        if(mensaje.equals("menu")){
                respuesta="****BIENVENIDOS A LA RESERVA DE ENTRADAS****\n"
                        + "1. Reservar entradas lat. izq\n"
                        + "2. Reservar entradas lat. derch\n"
                        + "3. Reservar entradas Galeria\n"
                        + "4. Reservar entradas Centrales\n"
                        + "5. Reservar entradas Palco vip1\n"
                        + "6. Reservar entradas Palco vip2\n"
                        + "7. Ver precios y entradas\n"
                        + "8. Salir\n";
            chatView.append("Server: " + respuesta + "\n"); 
            out.println(respuesta); 
        
        }else if(mensaje.equals("1")){
            entradas=lat1;        
        }else if(mensaje.equals("2")){
            entradas=lat2;    
        }else if(mensaje.equals("3")){
            entradas=gal;    
        }else if(mensaje.equals("4")){
            entradas=cen;    
        }else if(mensaje.equals("5")){
            entradas=vip1;    
        }else if(mensaje.equals("6")){
            entradas=vip2;    
        }else if(mensaje.equals("7")){
            respuesta="Quedan "+lat1+" entradas lat. izq\t Precio: 100€\n"
                            + "Quedan "+lat2+" entradas lat. derch\t Precio: 100€\n"
                            + "Quedan "+gal+" entradas Galeria\t Precio: 150€\n"
                            + "Quedan "+cen+" entradas Centrales\t Precio: 80€\n"
                            + "Quedan "+vip1+" entradas Palco vip1\t Precio: 250€\n"
                            + "Quedan "+vip2+" entradas Palco vip2\t Precio: 250€";   
            chatView.append("Server: " + respuesta + "\n");
            out.println(respuesta);  
        }else if(mensaje.equals("8")){
            chatView.append("Server: cerrando la conexion \n");
            out.println("cerrando la conexion"); 
        }
        else{
            chatView.append("Error \n");
            out.println("Error"); 
        }
        
        if(entradas>0){
            entradas--;
            respuesta="Entrada reservada";
            chatView.append("Server: " + respuesta + "\n");
            out.println(respuesta); 
        }else{
            respuesta="Entradas agotadas";
            chatView.append("Server: " + respuesta + "\n"); 
            out.println(respuesta); 
        }
    }
}