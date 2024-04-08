/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
            
        return maxDepthHelper(root, 1);
    }

    private int maxDepthHelper(TreeNode node, int depth) {
        if (node.left == null && node.right == null)
            return depth;

        int deeperDepth = ++depth;
        if (node.left != null && node.right != null) {
            return Math.max(maxDepthHelper(node.left, deeperDepth), maxDepthHelper(node.right, deeperDepth));
        }
        if (node.left == null)
            return maxDepthHelper(node.right, deeperDepth);
        else
            return maxDepthHelper(node.left, deeperDepth);
    }
}