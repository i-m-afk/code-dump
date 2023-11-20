import java.util.LinkedList;
import java.util.Queue;

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

    private static void levelOrder(Node node) {
        Queue<Node> que = new LinkedList<>();
        que.offer(node);
        while (!que.isEmpty()) {
            Node x = que.poll();
            if (x.left != null) {
                que.offer(x.left);
            }
            if (x.right != null) {
                que.offer(x.right);
            }
            System.out.print(x.val + " ");
        }
    }

    private static void levelOrderLinebyLine(Node node) {
        if (node == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        q.offer(null);
        while (!q.isEmpty()) {
            Node current = q.poll();
            // if reached current level end, there will be a null node marker
            if (current == null) {
                System.out.println();
                if (!q.isEmpty())
                    q.add(null);
                continue;
            }
            System.out.print(current.val + " ");
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    // Time : O(N) Space : O(N)
    private static void levelOrderLinebyLineOtherway(Node node) {
        if (node == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                Node current = q.poll();
                System.out.print(current.val + " ");
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            System.out.println();
        }
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
        System.out.println();
        levelOrder(root);
        System.out.println();
        levelOrderLinebyLine(root);
        System.out.println();
        levelOrderLinebyLineOtherway(root);
    }
}
