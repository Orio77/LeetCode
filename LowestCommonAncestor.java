import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class MySolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Use BFS to find p ancestors
        List<TreeNode> pAncestors = BFS(root, p);
        // Use BFS to find q andectors
        List<TreeNode> qAncestors = BFS(root, q);
        // Determine lowest common ancestor
        int i = pAncestors.size() - 1;
        int j = qAncestors.size() - 1;
        TreeNode lca = null;
        while (i >= 0 && j >= 0 && pAncestors.get(i) == qAncestors.get(j)) {
            lca = pAncestors.get(i);
            i--;
            j--;
        }
        return lca;
    }

    public List<TreeNode> BFS(TreeNode root, TreeNode target) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parents.put(root, null);
        queue.add(root);
        TreeNode cur;

        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                parents.put(cur.left, cur);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                parents.put(cur.right, cur);
                queue.add(cur.right);
            }
        }
        if (!parents.containsKey(target)) {
            return new ArrayList<>();
        }

        List<TreeNode> ancestors = new ArrayList<>();
        TreeNode dummy = target;
        TreeNode temp = parents.get(dummy);
        while (temp != null) {
            ancestors.add(temp);
            dummy = temp;
            temp = parents.get(dummy);
        }
        ancestors.add(target);

        return ancestors;
    }

    public PriorityQueue<TreeNode> DFS(TreeNode root, TreeNode target, PriorityQueue<TreeNode> ancestors) {
        if (root == null) {
            return ancestors;
        }
        ancestors.add(target);
        if (root == target) {
            return ancestors;
        }

        return DFS(root.right, target, DFS(root.left, target, ancestors));
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, null, parent);

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

    public void dfs(TreeNode child, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (child != null) {
            map.put(child, parent);
            dfs(child.left, child, map);
            dfs(child.right, child, map);
        }
    }
}