package DetectCycle;

/* Problem Statement: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//helper class pair
class Pair<L, R> {
    L left;
    R right;

    Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }
}

public class UndirectedGraph {
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] visited) {
        visited[node] = true;
        for (int child : adj.get(node)) {
            if (parent == child)
                continue;
            if (visited[child]) // child != parent and already visited means cycle
                return true;
            if (dfs(adj, child, node, visited)) // any branch returns true then return true
                return true;
        }
        return false;
    }

    private boolean bfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] visited) {
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        visited[node] = true;
        que.offer(new Pair(node, parent));
        while (!que.isEmpty()) {
            node = que.peek().left;
            parent = que.peek().right;
            que.poll();
            for (int child : adj.get(node)) {
                if (parent == child)
                    continue;
                if (visited[child])
                    return true;
                visited[child] = true;
                que.offer(new Pair(child, node));
            }
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && bfs(adj, i, -1, visited)) // call for each node (not joined graph)
                return true;
        }
        return false;
    }
}
