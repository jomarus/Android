package socketentradas_ServidorJframe;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleChatServer {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started. Listening to the port 4444. Waiting for the client.");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected on port 4444.");
        } catch (IOException e) {
            System.out.println("Could not listen on port: 4444");
            e.printStackTrace();
            return;
        }
        
        ChatWindow chatWindow = new ChatWindow();
        chatWindow.open(serverSocket,clientSocket);
    }

}
