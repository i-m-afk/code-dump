import java.util.ArrayList;
public class Kdistance extends Node {

    Kdistance(int val) {
        super(val);
    }

    ArrayList<Integer> res;

    void solve(Node node, int k) {
        if (node == null)
            return;
        if (k == 0) {
            res.add(node.val);
        }
        solve(node.left, k - 1);
        solve(node.right, k - 1);
    }

    /**
     * print nodes at distance k from root
     * 
     * @param node
     * @param k
     * @return {ArrayList<Integer>}
     */
    ArrayList<Integer> printK(Node node, int k) {
        res = new ArrayList<Integer>();
        solve(node, k);
        return res;
    }

    /**
     * print nodes at k distance from any given node in binary tree
     * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
     * 
     * @param {Node} root
     * @param {Node} targetNode
     * @param {int}  k - distance
     * @return {List<Integer>}
     */

    // List<Integer> distance(Node root, Node targetNode, int k) {
    // findTarget(root, targetNode);
    // return printK(root, newK);
    // }

}
