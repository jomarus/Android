package socketentradas_ServidorJframe;

import java.awt.Container;
import java.awt.FlowLayout;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ChatWindow extends JFrame {

    private JTextArea chatView;

    //Abrir la ventana del servidor
    public void open(ServerSocket serverSocket,Socket clientSocket) {

        initComponents();

        initSenderAndReceiver(clientSocket,serverSocket);

    }

    //Inicializar Jframe
    private void initComponents() {

        chatView = new JTextArea(26, 48);
        JScrollPane chatViewScrollPane = new JScrollPane(chatView);
        
        setResizable(false);
        setTitle("Visor Server");
        setSize(545, 455);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(chatViewScrollPane);
        chatView.setEditable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Iniciar el envio de mensajes
    private void initSenderAndReceiver(final Socket clientSocket,ServerSocket serverSocket) {

       Receiver receiver = new Receiver(serverSocket,clientSocket, chatView);

        Thread receiverThread = new Thread(receiver);
        receiverThread.run();
    }
}
