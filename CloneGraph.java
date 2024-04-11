import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    
}



// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
    public Node cloneGraph(Node node) {
        
        Map<Node, List<Node>> original = new HashMap<>();
        Map<Node, Node> oldToCopy = new HashMap<>();

        addNode(node, original, oldToCopy);

        for (Node neighbor : original.keySet()) {
            Node copy = oldToCopy.get(neighbor);

            for (Node nearby : neighbor.neighbors) {
                if (copy.neighbors == null) {
                    copy.neighbors = new ArrayList<>();
                }

                if (!copy.neighbors.contains(oldToCopy.get(nearby))) {
                    copy.neighbors.add(oldToCopy.get(nearby));
                }
            }
        }
        return oldToCopy.get(node);
    }

    private void addNode(Node node, Map<Node, List<Node>> original, Map<Node, Node> oldToCopy) {
        if (node == null || original.containsKey(node)) {
            return;
        }
        original.put(node, null);
        oldToCopy.putIfAbsent(node, new Node(node.val));

        for (Node neighbor : node.neighbors) {
            addNode(neighbor, original, oldToCopy);
        }
    }
}