public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        // Create nodes
        TreeNode node10 = new TreeNode(10);
        TreeNode node42 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8, node42, null);
        TreeNode node4 = new TreeNode(4, node10, node8);
        TreeNode root = new TreeNode(4, null, node4);

        // Create One instance and call method
        One One = new One();
        int result = One.goodNodes(root);

        // Print result
        System.out.println("Number of good nodes: " + result);
    }
}



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
class One {
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