import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator; 

public class mst implements mst_interface {
    HashMap<String, SortedSet<Edge>> edges;
    HashMap<String, Integer> nodes;
    public mst() {
        super();
        edges = new HashMap<String, SortedSet<Edge>>();
        nodes = new HashMap<String, Integer>();
    }
    public void add_graph(String identifier, int N) {
        this.edges.put(identifier, new TreeSet<Edge>());
        this.nodes.put(identifier, N);
    }
    
    public void add_edge(String identifier, int U, int V, int W) {
        Edge edge = new Edge(U, V, W);

        edges.get(identifier).add(edge);
    }

    private int find(int V, int[] parent) {
        if(parent[V] == V) {
            return V;
        }
        return parent[V] = find(parent[V], parent);
    }
    
    private int Union(int U, int V, int W, int mst_weight, int[] size, int[] parent) {
        if(U == V) {
            return mst_weight;
        }
        if(size[U] <= size[V]) {
            parent[U] = parent[V];
            size[V] += size[U];
        } else {
            parent[V] = parent[U];
            size[U] += size[V];
        }
        return mst_weight + W;
    }

    public int get_mst(String identifier) {
        SortedSet<Edge> cur_edges = edges.get(identifier);
        int N = nodes.get(identifier);
        int[] parent, size;
        parent = new int[N + 1];
        size = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int mst_weight = 0;
        Iterator<Edge> iterator = cur_edges.iterator();
        while(iterator.hasNext()) {
            Edge edge = iterator.next();
            int U = edge.U, V = edge.V, W = edge.W;
            int king1 = find(U, parent);
            int king2 = find(V, parent);
            mst_weight = Union(king1, king2, W, mst_weight, size, parent);   
        }
        for(int i = 1; i <= N; i++) {
            parent[i] = find(i, parent);
        }
        int leader = parent[1];
        for(int i = 1; i <= N; i++) {
            if(parent[i] != leader) {
                return -1;
            }
        }
        return mst_weight;
    }
}