import java.util.HashMap;
import java.util.Map;


class Trie {
    private Node node;

    class Node {
        private Map<Character, Node> map; 
        private boolean endOfWord;

        public Node() {
            endOfWord = false;
            map = new HashMap<>();
        }
    }

    public Trie() {
        this.node = new Node();
    }
    
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node curr = this.node;

        for (char c : chars) {
            curr.map.putIfAbsent(c, new Node());
            curr = curr.map.get(c);
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node curr = this.node;

        for (char c : chars) {
            if (curr.map == null || !curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();

        Node curr = this.node;
        for (char c : chars) {
            if (curr.map == null || !curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return true;
    }
}