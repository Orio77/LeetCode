package repeat;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxLeft = maxDepth(node.left);
        int maxRight = maxDepth(node.right);

        diameter = Math.max(diameter, maxLeft + maxRight);

        return Math.max(maxLeft, maxRight) + 1;
    }
}
