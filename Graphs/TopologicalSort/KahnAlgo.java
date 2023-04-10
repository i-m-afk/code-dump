package TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class KahnAlgo {

    // Method to perform topological sorting using Kahn's Algorithm
    private int[] topoSort(ArrayList<ArrayList<Integer>> adj, int V) {

        // Initialize an array to keep track of the indegree of each node
        int[] indegree = new int[V];

        // Initialize an array to store the sorted order of nodes
        int[] result = new int[V];

        // Initialize a queue to store nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        // Calculate the indegree of each node
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }

        // Enqueue all nodes with indegree 0
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // Process nodes in the queue
        int i = 0;
        while (!queue.isEmpty()) {
            int curr = queue.peek();
            result[i++] = queue.poll();
            for (int v : adj.get(curr)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // Return the sorted order of nodes
        return result;
    }
}
