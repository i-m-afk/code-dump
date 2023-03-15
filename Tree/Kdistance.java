public class Kdistance extends Node {

    Kdistance(int val) {
        super(val);
    }

    private static void printK(Node node, int k, int count) {
        if (node == null)
            return;
        if (count == k) {
            System.out.print(node.val + " ");
            return;
        }
        count++;
        printK(node.left, k, count);
        printK(node.right, k, count);
    }

    // print nodes at k distance from the root
    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(40);
        root.right = new Node(50);
        root.left.left = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        printK(root, 2, 0);
        /*
         * 30
         * / \
         * 40 50
         * / / \
         * 70 60 80
         * 
         */

    }

}
