
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
    public int goodNodes(TreeNode root) {
        return helper(root, 0, root.val);
    }

    public int helper(TreeNode node, int goodNodes, int currMax) {
        if (node == null) {
            return goodNodes;
        }
        
        if (node.val >= currMax) {
            goodNodes++;
        }
        if (node.val > currMax) {
            currMax = node.val;
        }

        
        return helper(node.right, helper(node.left, goodNodes, currMax), currMax);
    }
}