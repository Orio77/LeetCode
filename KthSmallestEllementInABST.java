import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestEllementInABST {
    
}



class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> result = new PriorityQueue<>(Comparator.comparing(n -> n.val));
        getNodes(result, root);

        int i = 0;
        while (i < k-1) {
            result.poll();
            i++;
        }

        return result.poll().val;
    }

    public void getNodes(Queue<TreeNode> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root);

        getNodes(result, root.left);
        getNodes(result, root.right);
    }
}