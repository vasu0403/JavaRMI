public class Edge implements Comparable<Edge> {
    public int U, V, W;
    public Edge(int U, int V, int W) {
        this.U = U;
        this.V = V;
        this.W = W;
    }
    public int compareTo(Edge cur) {
        if(this.W <= cur.W) {
            return -1;
        } else {
            return 1;
        }
    }
}