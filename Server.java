import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends mst {
    public Server() {}
    public static void main(String args[]) {
        try {
        	String host = "127.0.0.1";
        	int port = Integer.parseInt(args[0]);
        	LocateRegistry.createRegistry(port);

            mst MST  = new mst();
            
            mst_interface stub = (mst_interface) UnicastRemoteObject.exportObject(MST, 0);

            Registry registry = LocateRegistry.getRegistry(host, port);

            registry.bind("graph_mst", stub);

            System.err.println("Server Running");
        } catch (Exception e) {
            System.out.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}