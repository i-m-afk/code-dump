package GraphTravel;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjencyList {
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

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < V; i++) {
            System.out.println("Node u: ");
            int u = sc.nextInt();
            System.out.println("Node v: ");
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }
        sc.close();
        printGraph(adj);
    }
}
