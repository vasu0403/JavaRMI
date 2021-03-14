import java.rmi.Remote;
import java.rmi.RemoteException;

public interface mst_interface extends Remote {
   void add_graph(String identifier, int N) throws RemoteException;
   void add_edge(String identifier, int u, int v, int w) throws RemoteException;
   int get_mst(String identifier) throws RemoteException;
}