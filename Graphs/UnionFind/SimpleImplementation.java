package UnionFind;

public class SimpleImplementation {
    static int[] parent;

    static void initialize(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    static int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return find(parent[a]);
    }

    static void union(int a, int b) {
        // get representatives
        int a_rep = find(a);
        int b_rep = find(b);
        if (a_rep == b_rep)
            return;
        // make second rep child of 1st rep
        parent[b_rep] = a_rep;
    }

    public static void main(String[] args) {
        int n = 5;
        parent = new int[n];
        initialize(parent);

        union(0, 2);
        union(2, 4);
        union(1, 3);

        for (int i : parent) {
            System.out.print(i + " ");
        }
        // Time Complexity:
        // Worst case : Chaining can happen (1 parent/rep for every node)
        // BigO(n)
    }
}
