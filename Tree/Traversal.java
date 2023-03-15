public class Traversal extends Node {
    Traversal(int val) {
        super(val);
    }

    // traversing left sub tree first then right (root traverse depends on name)
    private static void preOrder(Node node) {
        // pre-order means root first
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void postOrder(Node node) {
        // post-order means root last
        if (node == null)
            return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.val + " ");
    }

    private static void inOrder(Node node) {
        // post-order means root in between
        if (node == null)
            return;
        preOrder(node.left);
        System.out.print(node.val + " ");
        preOrder(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(40);
        root.right = new Node(50);
        root.left.left = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        inOrder(root);
    }
}
