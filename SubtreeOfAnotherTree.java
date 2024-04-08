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
class S {
    public boolean isSubtreeFirstApproach(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        
        // get values for root, save them
        List<Integer> bigVals = getValues(root, new ArrayList<>());
        // get values for subRoot, save them
        List<Integer> smallVals = getValues(subRoot, new ArrayList<>());
        // Use while loop to iterate over the values of main tree (i - subTree.size())
        int i = 0;
        int bigSize = bigVals.size();
        int smallSize = smallVals.size();
        int limit = bigSize - smallSize;
        int subRootVal = smallVals.get(0);

        for (i = 0; i < bigSize; i++) {
            if (bigVals.get(i) == subRootVal) {
                break;
            }
        }
        if (i > limit) {
            return false;
        }
        // if the root matches a value, iterate over the rest of values of subTree whether they match
        for (int j = 0; j < smallSize; j++, i++) {
            if (bigVals.get(i) != smallVals.get(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubtreeSecondAttempt(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        
        // get subRoot value
        int targetVal = subRoot.val;
        // get potential subroots by value : if the list is empty, return false
        List<TreeNode> result = getPotentialSubTreeRoots(root, new ArrayList<>(), targetVal);
        if (result.isEmpty()) {
            return false;
        }
        // get subRoot values
        List<Integer> vals = getValues(subRoot, new ArrayList<>());
        // for each potential subroot, check if the values are the same as in subRoot
        for (TreeNode node : result) {
            List<Integer> potentialResultVals = getValues(node, new ArrayList<>());
            if (vals.size() != potentialResultVals.size()) {
                return false;
            }
            for (int i = 0; i < vals.size(); i++) {
                if (vals.get(i) != potentialResultVals.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Integer> getValues(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        return getValues(root.right, getValues(root.left, list));
    }

    public List<TreeNode> getPotentialSubTreeRoots(TreeNode originalRoot, List<TreeNode> list, int subRootVal) {
        if (originalRoot == null) {
            return list;
        }
        if (originalRoot.val == subRootVal) {
            list.add(originalRoot);
        }
        return getPotentialSubTreeRoots(originalRoot.left, getPotentialSubTreeRoots(originalRoot.right, list, subRootVal), subRootVal);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}