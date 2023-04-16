package UnionFind;

import java.util.Arrays;

class Edge implements Comparable<Edge> {
    int src, dest, wt;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        wt = w;
    }

    // for sorting edges
    public int compareTo(Edge e) {
        return this.wt - e.wt;
    }
}

public class KruskalAlgo {
    static int[] parent;
    static int[] rank;
    static int V;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if (x_rep == y_rep)
            return;
        // smaller tree becomes child
        if (rank[x_rep] < rank[y_rep])
            parent[x_rep] = y_rep;
        else if (rank[y_rep] < rank[x_rep])
            parent[y_rep] = x_rep;
        else {
            parent[y_rep] = x_rep;
            rank[x_rep]++; // height increases by one as y_rep height is same as x_rep and x_rep size
                           // increase by 1 because it is parent of y rep
        }
    }

    static int kruskal(Edge[] edges) {
        // sort edges
        Arrays.sort(edges);
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int res = 0;
        for (int i = 0, s = 0; s < V - 1; i++) {
            Edge e = edges[i];
            int x = find(e.src);
            int y = find(e.dest);
            if (x != y) {
                System.out.println(e.src + "---" + e.dest);
                res += e.wt;
                union(x, y);
                s++; // increase current size
            }
        }
        return res;
    }

    public static void main(String[] args) {
        V = 5;
        parent = new int[V];
        rank = new int[V];
        Edge[] edges = new Edge[7];
        // populating the graph
        edges[0] = new Edge(0, 2, 8);
        edges[1] = new Edge(0, 1, 10);
        edges[2] = new Edge(1, 2, 5);
        edges[3] = new Edge(1, 3, 3);
        edges[4] = new Edge(2, 3, 4);
        edges[5] = new Edge(2, 4, 12);
        edges[6] = new Edge(3, 4, 15);

        System.out.println("Edges: ");
        System.out.print("Minumum Cost Spanning Tree: " + kruskal(edges));
        // Time Complexity
        // Sorting: BigO(ElogE) + Initializing: BigO(E) + Traversing & Find and
        // Union(by rank and path compression) BigO(V)
    }
}
