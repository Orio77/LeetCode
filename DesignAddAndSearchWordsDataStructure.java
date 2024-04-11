import java.util.HashMap;
import java.util.Map;

class WordDictionary {
    private Node node;

    class Node {
        private Map<Character, Node> map;
        private boolean isEndOfWord;

        public Node() {
            map = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public WordDictionary() {
        this.node = new Node();
    }
    
    public void addWord(String word) {
        
        char[] chars = word.toCharArray();
        Node curr = this.node;

        for (char c : chars) {
            curr.map.putIfAbsent(c, new Node());
            curr = curr.map.get(c);
        }

        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return search(word, this.node);
    }

    private boolean search(String word, Node node) {
        if (word.length() == 0 && node.isEndOfWord) {
            return true;
        }
        if (word == null || word.length() == 0) {
            return false;
        }
        
        char[] chars = word.toCharArray();
        Node curr = node;

        for (char c : chars) {
            if (c == '.') {
                for (char innerC : curr.map.keySet()) {
                    if (search(word.substring(word.indexOf(c)+1), curr.map.get(innerC))) {
                        return true;
                    }
                }
            }

            curr = curr.map.get(c);
            if (curr == null) {
                return false;
            }
        }
        return curr.isEndOfWord;
    }
}
