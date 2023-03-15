public class Kdistance extends Node {

    Kdistance(int val) {
        super(val);
    }

    private static void printK(Node node, int k) {
        if (node == null)
            return;
        if (k == 0) {
            System.out.print(node.val + " ");
        }
        printK(node.left, k - 1);
        printK(node.right, k - 1);
    }

    // print nodes at k distance from the root
    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(40);
        root.right = new Node(50);
        root.left.left = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        printK(root, 2);
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
