package repeat;

public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validateBST(TreeNode node, long lowerBound, long upperBound) {
        if (node.val <= lowerBound || node.val >= upperBound) {
            return false;
        }

        boolean left = true, right = true;

        if (node.left != null) {
            left = validateBST(node.left, lowerBound, node.val);
        }
        if (node.right != null) {
            right = validateBST(node.right, node.val, upperBound);
        }

        return left && right;
    }
}
