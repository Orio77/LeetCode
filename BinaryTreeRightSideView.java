import java.util.ArrayList;
import java.util.List;

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
class MySolution {
    private int answerLevel;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<TreeNode> answerNodes = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        TreeNode dummy = root;

        while (dummy != null) {
            answerNodes.add(dummy);
            answer.add(dummy.val);
            dummy = dummy.right;
            answerLevel++;
        }

        for (int i = 1; i < answerNodes.size(); i++) {
            answer = viewHelper(answerNodes.get(i), i, answerLevel, answer);
        }

        if (root.left != null) {
            return viewHelper(root.left, 2, answerLevel, answer);
        }

        return answer;
    }

    private List<Integer> viewHelper(TreeNode node, int currentLevel, int answerLevel, List<Integer> answer) {
        if (currentLevel-1 == answerLevel && !answer.contains(node.val)) {
            answer.add(node.val);
        }
        if (node.right != null) {
            if (currentLevel > answerLevel) {
                answer.add(node.right.val);
                answer = viewHelper(node.right, ++currentLevel, ++answerLevel, answer);
            }
            else {
                viewHelper(node.right, ++currentLevel, answerLevel, answer);
            }
        }
        if (node.left != null) {
            if (currentLevel > answerLevel) {
                answer.add(node.left.val);
                answer = viewHelper(node.left, ++currentLevel, ++answerLevel, answer);
            }
            else {
                viewHelper(node.left, ++currentLevel, answerLevel, answer);
            }
        }
        return answer;
    }
}


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth);
        rightView(curr.left, result, currDepth);
    }
}
