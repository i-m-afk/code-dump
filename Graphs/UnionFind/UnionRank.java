package UnionFind;

public class UnionRank {
    static int[] parent;
    static int[] rank; // rank = height of the tree

    static void initialize() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return find(parent[x]);
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

    public static void main(String[] args) {
        int n = 5;
        parent = new int[n];
        rank = new int[n];
        initialize();

        union(0, 2);
        union(2, 4);
        union(1, 3);

        for (int i : parent) {
            System.out.print(i + " ");
        }
        // Time Complexity : O(log n)
    }
}
