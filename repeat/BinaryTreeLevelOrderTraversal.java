package repeat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    
    public List<List<TreeNode>> getLevels(TreeNode root) {
        
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> level;
        int qLength;

        while (!queue.isEmpty()) {
            level = new ArrayList<>();
            qLength = queue.size();
            for (int i = 0; i < qLength; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    level.add(curr);
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
