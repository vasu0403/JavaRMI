import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() {}
    
    public static void main(String args[]) {
        try {
        	String host = args[0];
        	int port = Integer.parseInt(args[1]);
            Registry registry = LocateRegistry.getRegistry(host, port);

            mst_interface stub = (mst_interface) registry.lookup("graph_mst");
            Scanner sc= new Scanner(System.in);
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] split_line = line.split(" ");
                
                String operation = split_line[0];
                String identifier = split_line[1];
                if(operation.equals("add_graph")) {
                    int nodes = Integer.parseInt(split_line[2]);
                    stub.add_graph(identifier, nodes);
                } else if(operation.equals("add_edge")) {
                    int U = Integer.parseInt(split_line[2]);
                    int V = Integer.parseInt(split_line[3]);
                    int W = Integer.parseInt(split_line[4]);
                    stub.add_edge(identifier, U, V, W);
                } else if(operation.equals("get_mst")) {
                    int mst_weight = stub.get_mst(identifier);
                    System.out.println(mst_weight);
                }
            }
        } catch (Exception e) {
            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}