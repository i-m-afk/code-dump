import java.util.*;

public class dfs {
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        // undirected graph
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++)
            for (int v : graph.get(i))
                System.out.println("Node " + i + "--->" + v);
    }

    static void dfSearch(ArrayList<ArrayList<Integer>> graph, int start) {
        int V = graph.size();
        boolean isVisited[] = new boolean[V];
        Stack<Integer> stk = new Stack<Integer>();

        stk.add(start);
        isVisited[start] = true;

        while (!stk.isEmpty()) {

            int node = stk.pop();
            System.out.print(node + "-->");

            for (int j : graph.get(node)) {
                if (!isVisited[j]) {
                    stk.add(j);
                    isVisited[j] = true;
                }
            }
        }
        System.out.print("null");
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
        System.out.println("DFS traversel form node 3");
        dfSearch(adj, 3);
    }
}
