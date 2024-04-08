import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> levelList;
        if (root != null) {
            queue1.add(root);
            levels.add(List.of(root.val));
        }
        int level = 0;

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            Queue<TreeNode> curQueue = (level % 2 == 0) ? queue1 : queue2;
            levelList = new ArrayList<>();
            Iterator<TreeNode> iterator = curQueue.iterator();
            while (iterator.hasNext()) {
                TreeNode treeNode = iterator.next();
                if (treeNode.left != null) {
                    (curQueue.equals(queue1) ? queue2 : queue1).add(treeNode.left);
                    levelList.add(treeNode.left.val);
                }
                if (treeNode.right != null) {
                    (curQueue.equals(queue1) ? queue2 : queue1).add(treeNode.right);
                    levelList.add(treeNode.right.val);
                }
                iterator.remove();
            }
            if (!levelList.isEmpty()) {
                levels.add(levelList);
            }
            level++;
        }
        return levels;
    }
}