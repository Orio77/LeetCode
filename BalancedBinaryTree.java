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
    public boolean isBalanced(TreeNode root) {
        if (root == null) 
            return true;
        
        int leftHeight = 0;
        int rightHeight = 0;
        if (root.left != null) {
            leftHeight = getHeight(root.left, 1);
            if (!isBalanced(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            rightHeight = getHeight(root.right, 1);
            if (!isBalanced(root.right)) {
                return false;
            }
        }

        return (Math.abs(rightHeight - leftHeight) > 1) ? false : true; 
    }

    public int getHeight(TreeNode node, int level) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null) {
            leftHeight = getHeight(node.left, level+1);
        }
        if (node.right != null) {
            rightHeight = getHeight(node.right, level+1);    
        }

        return (leftHeight == 0 && rightHeight == 0) ? level : Math.max(leftHeight, rightHeight);
    }
}