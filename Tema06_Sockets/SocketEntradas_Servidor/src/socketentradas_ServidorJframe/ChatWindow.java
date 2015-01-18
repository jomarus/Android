package socketentradas_ServidorJframe;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This is the GUI component for chat window.
 * 
 * @author Lak J Comspace (http://lakjeewa.blogspot.com)
 * 
 */
public class ChatWindow extends JFrame {

    private JTextArea chatView;

    /**
     * This method open the chat window.
     * 
     * @param clientSocket
     *            Socket which has been opened for chat
     */
    public void open(final Socket clientSocket) {

        initComponents();

        initSenderAndReceiver(clientSocket);

    }

    /**
     * This method initialize the components of the chat winodow.
     */
    private void initComponents() {

        chatView = new JTextArea(26, 48);
        JScrollPane chatViewScrollPane = new JScrollPane(chatView);
        
        setResizable(false);
        setTitle("Visor Server");
        setSize(545, 455);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(chatViewScrollPane);
        //contentPane.add(chatBoxScrollPane);
        //contentPane.add(sendButton);
        chatView.setEditable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This method initialize the chat sender and receiver for this chat window.
     * 
     * @param clientSocket
     *            Socket which has been opened for chat
     */
    private void initSenderAndReceiver(final Socket clientSocket) {

       Receiver receiver = new Receiver(clientSocket, chatView);

        Thread receiverThread = new Thread(receiver);
        receiverThread.run();
    }
}
