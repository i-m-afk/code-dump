public class Height extends Node {
    Height(int val) {
        super(val);
    }

    private static int getHeight(Node node) {
        // Find height of left subtree
        // Find height of right subtree
        // Get max of two and 1 to it

        // base case
        if (node == null)
            return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(40);
        root.right = new Node(50);
        root.left.left = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        System.out.println(getHeight(root));
    }
}
