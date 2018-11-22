package BackendLayer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

public class Server {
    /**
     * The threadpool of the server
     */
    private ExecutorService threadpool;
    /**
     * the file manager of the server
     */
    private ServerSocket server;
    /**
     * The constructor of the server
     * @param portNumber - the port number the server listens on
     */
    public Server(int portNumber) {
        try {
            threadpool = Executors.newCachedThreadPool();
            server = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server is running.");
    }
    /**
     * communicates with clients of the server.
     */
    public void communicate() {
        try {
            while (true) {
                Worker worker = new Worker(server.accept());
                threadpool.execute(worker);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Starts up the server
     * @param args - the arguments of the command line
     */
    public static void main(String[] args) {
        Server server = new Server(9890);
        server.communicate();
    }
}
