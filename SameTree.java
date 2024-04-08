import java.util.ArrayList;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return (p == null && q == null);
        }
        ArrayList<Integer> pList = getValues(p, new ArrayList<>());
        pList.add(p.val);
        ArrayList<Integer> qList = getValues(q, new ArrayList<>());
        qList.add(q.val);

        if (pList.size() != qList.size()) {
            return false;
        }

        for (int i = 0; i < pList.size(); i++) {
            if (pList.get(i) != qList.get(i)) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> getValues(TreeNode node, ArrayList<Integer> nodeList) {
        if (node == null) {
            return nodeList;
        }
        nodeList.add(node.left == null ? null : node.left.val);
        nodeList.add(node.right == null ? null : node.right.val);
        if (node.left != null && node.right == null) {
            nodeList.remove(nodeList.size()-1);
        }
        
        return getValues(node.right, getValues(node.left, nodeList));
    }
}