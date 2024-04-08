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
// My Take
class MySolution {
    public int diameterOfBinaryTree(TreeNode root) {
        return (root == null) ? 0 : diameterOfBinaryTreeHelper(root, 1);
    }

    private int diameterOfBinaryTreeHelper(TreeNode node, int level) {
        int maxDepthLeft = 0;
        int maxDepthRight = 0;
        int diameter = 0;
        if (node.left != null) {
            maxDepthLeft = maxDepth(node.left, level+1);
        }
        if (node.right != null) {
            maxDepthRight = maxDepth(node.right, level+1);
        }
        if (maxDepthLeft == 0 || maxDepthRight == 0) {
            diameter = maxDepthLeft + maxDepthRight - 1;
        }
        else 
            diameter = maxDepthLeft + maxDepthRight - 2;

        return Math.max(diameter, Math.max(diameterOfBinaryTree(node.right), diameterOfBinaryTree(node.left)));
    }

    public int maxDepth(TreeNode node, int level) {
        int maxLeft = 0;
        int maxRight = 0;
        if (node.left != null) {
            maxLeft = maxDepth(node.left, level+1);
        }
        else if (node.right != null) {
            maxRight = maxDepth(node.right, level+1);
        }
        return (maxLeft == 0 && maxRight == 0) ? level : Math.max(maxLeft, maxRight);
    }
}


// Solution
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] diameter = new int[1];
        maxDepth(root, diameter);
        return diameter[0];
    }

    private int maxDepth(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.left, diameter);
        int right = maxDepth(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left+right);
        return Math.max(left, right)+1;
    }
}
