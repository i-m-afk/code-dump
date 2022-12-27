import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class bfs {
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        // undirected graph
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void bfsearch(ArrayList<ArrayList<Integer>> graph, int start) {
        int V = graph.size();
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new ArrayDeque<Integer>();

        visited[start] = true;
        queue.offer(start);
        for (int i = 0; i < V; i++) {
            int val = queue.poll();
            System.out.print(val + "--->");
            // adj list rep makes finding neighbours easier and faster
            for (int j : graph.get(val)) {
                if (!visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
        System.out.println("null");
    }

    static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++)
            for (int v : graph.get(i))
                System.out.println("Node " + i + "--->" + v);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 1, 2);
        addEdge(adj, 0, 4);
        addEdge(adj, 3, 2);
        addEdge(adj, 3, 1);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 2);
        addEdge(adj, 0, 3);
        printGraph(adj);
        System.out.println("BFS traversel form node 3");
        bfsearch(adj, 1);
    }

}
