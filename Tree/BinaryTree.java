import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    /**
     * Method to return total number of nodes in binary tree
     * 
     * @param {Node} root
     * @return Integer - total nodes in binary tree
     */
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    /**
     * 
     * @param Node root
     * @return maximum of all the nodes in binary tree
     *         Note: Integer.MIN_VALUE (-infintiy assumed)
     * 
     *         Time: O(N)
     *         Space: O(h) , h = height of tree
     */
    public static int maximumNodeValue(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.val, Math.max(maximumNodeValue(root.left), maximumNodeValue(root.right)));
    }

    /**
     * print left view (left most node at each level) of the binary tree
     * 
     * @param Node root
     * @return void
     * 
     *         1st each layer
     */
    public static void printLeftView(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i == 0)
                    System.out.println(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
    }

    public static void printRightView(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i == size - 1)
                    System.out.println(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
    }

    /**
     * minimum depth of the binary tree
     * 
     * @param root
     * @return int
     */

    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * If the given binary tree follows children sum property or not, parent is sum
     * of the values of its children(s)
     * 
     * @param root
     * @return
     */
    public static boolean isChildrenSum(Node root) {
        if (root == null) {
            return true;
        }
        int left = (root.left == null) ? 0 : root.left.val;
        int right = (root.right == null) ? 0 : root.right.val;
        int sum = left + right;

        return (root.val == sum) && isChildrenSum(root.left) && isChildrenSum(root.right);
    }

    /**
     * Check for height balanced binary tree (diff of height left subtree and right
     * subtree should not be more than 1)
     * 
     * @param args
     * 
     * 
     *             O(N^2) approach, can be done in better way
     */

    public static boolean isBalancedTree(Node root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return (Math.abs(leftHeight - rightHeight) <= 1) && isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    private static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public static boolean isBalancedTreeBetter(Node root) {
        return checkBalanced(root) != -1;
    }

    private static int checkBalanced(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkBalanced(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkBalanced(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        // root.left = new Node(40);
        // root.right = new Node(50);
        // root.left.left = new Node(70);
        // root.right.left = new Node(60);
        // root.right.right = new Node(80);

        // System.out.println(size(root));
        // System.out.println(maximumNodeValue(root));

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(12);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        // root.right.left.right = new Node(8);
        // printLeftView(root);
        // printRightView(root);
        System.out.println(isBalancedTreeBetter(root));
    }
}