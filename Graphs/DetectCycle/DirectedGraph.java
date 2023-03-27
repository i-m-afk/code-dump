package DetectCycle;

import java.util.ArrayList;
/*
 * Problem Statement: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 */

public class DirectedGraph {
    private boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, boolean[] inRecurrsion) {
        // marking the visited nodes as true
        visited[node] = true;
        inRecurrsion[node] = true;
        for (int v : adj.get(node)) {
            if (!visited[v] && isCycleDFS(adj, v, visited, inRecurrsion)) // if isCycleDFS gives true cycle is present
                return true;
            else if (inRecurrsion[v]) // already marked in Recursion then cycle detected
                return true;
        }
        // reseting the node before leaving recurssion
        inRecurrsion[node] = false;
        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        // need extra data structe :: inRecurrsion[] array
        boolean[] visited = new boolean[V];
        boolean[] inRecurrsion = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleDFS(adj, i, visited, inRecurrsion))
                    // cylce present
                    return true;
            }
        }
        // cycle not present
        return false;
    }
}
