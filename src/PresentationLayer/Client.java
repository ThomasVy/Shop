package PresentationLayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * RQ2: Operators should be able to add, remove, or update documents (book, journals, magazine, etc.)
 *
 * RQ5: Ordinary-buyers should be able to search for a book, to place an order, and to make payments.
 * They should also be able to register as a registered-buyer, if they wish.
 *
 * RQ6: Registered-Buyers should be able to have access to the promotions list that regularly will be
 * updated and registered-buyers will be notified.
 *
 * • RQ7: Registered-Buyers should be able to unsubscribe if they wish.
 */

public class Client {
    /**
     * The socket for communication between server and client
     */
    Socket socket;
    /**
     * The object output stream for the socket
     */
    ObjectOutputStream out;
    /**
     * The object input stream for the socket
     */
    ObjectInputStream in;

    /**
     * The client constructor
     * @param serverName - the server name to connect to
     * @param portNumber - the port number of server to connect to
     */
    public Client(String serverName, int portNumber) {
        try {
            socket = new Socket(serverName, portNumber);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Could not connect to Server");
            System.exit(0);
        }
    }
    public void communicate ()
    {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("type a string or 'quit' to exit");
            String request = scanner.nextLine();
            if(request.equalsIgnoreCase("quit"));
            sendRequest(request);
            try {
                System.out.println((String)in.readObject() +'\n');
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void sendRequest (Object object)
    {
        try {
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Client client = new Client("localhost", 9890);
        client.communicate();
    }
}
