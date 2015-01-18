package socketentradas_ServidorJframe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

/**
 * This is the chat receiver. This works as a thread and continuously check
 * whether a message is available in the input buffer.
 * 
 * @author Lak J Comspace (http://lakjeewa.blogspot.com)
 * 
 */
public class Receiver implements Runnable {

    private BufferedReader bufferedReader;
    private JTextArea chatView;
    private PrintWriter out;
    private int lat1=4,lat2=4;
    private int vip1=3,vip2=3;
    private int gal=8;
    private int cen=54;
        
    public Receiver(Socket clientSocket,JTextArea chatView) {
        this.chatView = chatView;
     
        try {
            //Recibir
            InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            
            //Enviar
            out = new PrintWriter(clientSocket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    
    @Override
    public void run() {

        String mensaje;
        String respuesta;
        
        while (true) {
            try {
                if (bufferedReader.ready()) {
                    mensaje = bufferedReader.readLine(); // Read the chat message.
                    chatView.append("Client: " + mensaje + "\n"); // Print the chat message on chat window.
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
                    }
                    else if(mensaje.equals("1")){
                            if(lat1>0){
                                lat1--;
                                respuesta="Quedan "+lat1+" entradas laterales izquierda";
                                chatView.append("Server: " + respuesta + "\n");
                                out.println(respuesta); 
                            }else{
                                respuesta="Entradas agotadas";
                                chatView.append("Server: " + respuesta + "\n"); 
                                out.println(respuesta); 
                            }
                    }else if(mensaje.equals("2")){
                            if(lat2>0){
                                lat2--;
                                respuesta="Quedan "+lat2+" entradas laterales izquierda";
                                chatView.append("Server: " + respuesta + "\n");
                                out.println(respuesta); 
                            }else{
                                respuesta="Entradas agotadas";
                                chatView.append("Server: " + respuesta + "\n"); 
                                out.println(respuesta); 
                            }
                    }else if(mensaje.equals("3")){
                            if(gal>0){
                                gal--;
                                respuesta="Quedan "+gal+" entradas Galeria";
                                chatView.append("Server: " + respuesta + "\n");
                                out.println(respuesta); 
                            }else{
                                respuesta="Entradas agotadas";
                                chatView.append("Server: " + respuesta + "\n"); 
                                out.println(respuesta); 
                            }
                    }else if(mensaje.equals("4")){
                            if(cen>0){
                                cen--;
                                respuesta="Quedan "+cen+" entradas Centrales";
                                chatView.append("Server: " + respuesta + "\n");
                                out.println(respuesta); 
                            }else{
                                respuesta="Entradas agotadas";
                                chatView.append("Server: " + respuesta + "\n"); 
                                out.println(respuesta); 
                            }
                    }else if(mensaje.equals("5")){
                            if(vip1>0){
                                vip1--;
                                respuesta="Quedan "+vip1+" entradas Palco vip1";
                                chatView.append("Server: " + respuesta + "\n");
                                out.println(respuesta); 
                            }else{
                                respuesta="Entradas agotadas";
                                chatView.append("Server: " + respuesta + "\n"); 
                                out.println(respuesta); 
                            }
                    }else if(mensaje.equals("6")){
                            if(vip2>0){
                                vip2--;
                                respuesta="Quedan "+vip2+" entradas Palco vip2";
                                chatView.append("Server: " + respuesta + "\n");
                                out.println(respuesta); 
                            }else{
                                respuesta="Entradas agotadas";
                                chatView.append("Server: " + respuesta + "\n"); 
                                out.println(respuesta); 
                            }
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
                        respuesta="Cerrando la conexion";
                        chatView.append(respuesta);
                        out.println(respuesta); 
                    }
                    else{
                        chatView.append("Error\n"); 
                        out.println("Error");   
                    }  

                }
            } catch (IOException ex) {
                System.out.println("Problem in message reading");
                ex.printStackTrace();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }
}
