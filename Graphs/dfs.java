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
    // Get the number of nodes in the graph
    int V = graph.size();

    // Create a boolean array to mark the nodes that have been visited
    boolean isVisited[] = new boolean[V];

    // Create a stack to store the nodes that need to be visited
    Stack<Integer> stk = new Stack<Integer>();

    // Add the starting node to the stack and mark it as visited
    stk.add(start);
    isVisited[start] = true;

    // Continuously pop a node from the stack and visit its neighbors
    while (!stk.isEmpty()) {
        // Pop the top node from the stack
        int node = stk.pop();
        // Print the node
        System.out.print(node + "-->");

        // Visit all of the unvisited neighbors of the node
        for (int j : graph.get(node)) {
            if (!isVisited[j]) {
                // Add the neighbor to the stack and mark it as visited
                stk.add(j);
                isVisited[j] = true;
            }
        }
    }

    // Print "null" after the traversal is complete
    System.out.print("null");
}


    static void recuressiveDFS(int node, boolean vis[], ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> ls) {

        vis[node] = true;
        ls.add(node);

        for (Integer it : graph.get(node)) {
            if (!vis[it]) {
                vis[it] = true;
                recuressiveDFS(it, vis, graph, ls);
            }

        }
    }

    static ArrayList<Integer> dfsOfGraph(int V, int start, ArrayList<ArrayList<Integer>> graph) {
        boolean vis[] = new boolean[V + 1];
        vis[start] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        recuressiveDFS(start, vis, graph, ls);
        return ls;
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
        System.out.println("DFS traversel form node 1");
        dfSearch(adj, 1);
        System.out.println("Recurssive DFS traversel form node 1");
        System.out.println(dfsOfGraph(V, 1, adj));
    }
}
