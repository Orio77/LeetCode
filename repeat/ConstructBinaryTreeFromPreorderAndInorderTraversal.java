package repeat;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    
}


class MySolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    public void preorder(TreeNode node) { // Provide a non null node here
        System.out.println(node.val);

        if (node.left != null) {
            preorder(node.left);
        }
        if (node.right != null) {
            preorder(node.right);
        }
    }

    public void inorder(TreeNode node) { // Provide a non null node here
        if (node.left != null) {
            inorder(node.left);
        }

        System.out.println(node.val);

        if (node.right != null) {
            inorder(node.right);
        }
    }
}


// ~What is preorder traversal?

// ~What is inorder traversal?

// How to get correct subtrees out of the arrays?

// How to insert the nodes?


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid+1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid+1, preorder.length), Arrays.copyOfRange(inorder, mid+1, preorder.length));
        return root;
    }
}