package backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
//communicates to client
public class Worker implements Runnable {
    /**
     * The object output stream to write to client
     */
    private ObjectOutputStream out;
    /**
     * The object input stream to read from client
     */
    private ObjectInputStream in;

    public Worker(Socket socketClient) {
        try {
            out = new ObjectOutputStream(socketClient.getOutputStream());
            in = new ObjectInputStream(socketClient.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the worker thread
     */
    @Override
    public void run() {
        while(true)
        {
            String request = null;
            try {
                request = (String)in.readObject();
                processRequest(request);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(request.equalsIgnoreCase("quit"))
            {
                break;
            }
        }
        //Todo something about the request
    }
    private void processRequest(String request)
    {
        try {
            out.writeObject(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
