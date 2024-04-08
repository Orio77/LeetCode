public class ValidateBinarySearchTree {
    
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
class Solution_v1 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}

class MySolution {
    public boolean isValidBST(TreeNode root) {
        return validateChildren(root, root.val);
    }

    public boolean validateChildren(TreeNode node, int rootVal) {
        if (node == null) {
            return true;
        }
        if (!validateLeft(node.left, rootVal) || !validateRight(node.right, rootVal)) {
            return false;
        }

        return validateChildren(node.left, node.val) && validateChildren(node.right, node.val);
    }

    public boolean validateRight(TreeNode node, int rootVal) {
        if (node == null) {
            return true;
        }
        if (node.val <= rootVal) {
            return false;
        }

        if (node.left != null && node.left.val <= rootVal) {
            return false;
        }
        if (node.right != null && node.right.val <= rootVal) {
            return false;
        }

        return validateRight(node.left, rootVal) && validateRight(node.right, rootVal);
    }

    public boolean validateLeft(TreeNode node, int rootVal) {
        if (node == null) {
            return true;
        }
        if (node.val >= rootVal) {
            return false;
        }

        if (node.left != null && node.left.val >= rootVal) {
            return false;
        }
        if (node.right != null && node.right.val >= rootVal) {
            return false;
        }

        return validateLeft(node.left, rootVal) && validateLeft(node.right, rootVal);
    }
}


class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}