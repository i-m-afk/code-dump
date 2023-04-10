package TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

class TopoSort {
    /**
     * Performs a depth-first search on every unvisited node in the graph.
     * When coming out of the loop, add the current node to the stack. This ensures
     * that the current node has no outgoing edges and confirms the correct order
     * for topological sorting (i.e., if there is an edge from u to v, then u should
     * come before v in the sorted list).
     *
     * @param adj     The adjacency list representation of the graph.
     * @param node    The current node being visited.
     * @param parent  The parent of the current node (for tree edges only).
     * @param visited An array indicating whether each node has been visited or not.
     * @param stk     The stack used to store the nodes in the correct order.
     */
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] visited,
            Stack<Integer> stk) {
        visited[node] = true;
        for (int child : adj.get(node)) {
            if (!visited[child]) {
                dfs(adj, child, node, visited, stk);
            }
        }
        stk.push(node);
    }

    /**
     * Returns a list containing the vertices of the graph in topological order.
     *
     * @param V   The number of vertices in the graph.
     * @param adj The adjacency list representation of the graph.
     * @return An array containing the vertices of the graph in topological order.
     */
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, -1, visited, stk);
            }
        }
        int[] res = new int[stk.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stk.pop();
        }
        return res;
    }
}
