package DetectCycle;

import java.util.ArrayList;

// Problem Statement: https://practice.geeksforgeeks.org/problems/detect-cycle-using-dsu/1
public class DSU {
    int parent[];
    int rank[];

    private void initialize() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private void union(int x, int y) {
        int rep_x = parent[x];
        int rep_y = parent[y];
        if (rank[rep_x] < rank[rep_y]) {
            parent[rep_x] = rep_y;
        } else if (rank[rep_y] < rank[rep_x]) {
            parent[rep_y] = rep_x;
        } else {
            parent[rep_x] = rep_y;
            rank[rep_y]++;
        }
    }

    private int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    // Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        parent = new int[V];
        rank = new int[V];
        initialize();
        for (int i = 0; i < V; i++) {
            for (int x : adj.get(i)) {
                if (find(i) == find(x)) {
                    if (x > i)
                        return 1;
                } else {
                    union(i, x);
                }
            }
        }
        return 0;
    }
}
