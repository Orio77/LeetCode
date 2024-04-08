import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class MyLRUCache {
    private Map<Integer, int[]> map;    // int[]{value, frequency}
    private Queue<int[]> pQueue;        // int[]{key, value, frequency}
    private final int capacity;

    public MyLRUCache(int capacity) {
        map = new HashMap<>();
        pQueue = new PriorityQueue<>((num1, num2) -> Integer.compare(num1[2], num2[2]));
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int[] res = map.getOrDefault(key, new int[]{-1});
        int answer = res[0];
        if (answer != -1) {
            map.replace(key, new int[]{map.get(key)[0], ++map.get(key)[1]});
            // pQueue.
        }
        return res[0];
    }
    
    public void put(int key, int value) {
        if (map.size() >= capacity) {
            int[] removePair = pQueue.poll();
            map.remove(removePair[0]);
        }
        map.put(key, new int[]{value, 0});
        pQueue.add(new int[]{key, value, 0});    
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


class LRUCache { 
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newNode) {
        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(Node delNode) {
        Node prevv = delNode.prev;
        Node nextt = delNode.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node resultNode = map.get(key);
            int ans = resultNode.val;

            map.remove(key);
            deleteNode(resultNode);
            addNode(resultNode);

            map.put(key, head.next);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            map.remove(key);
            deleteNode(curr);
        }

        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        map.put(key, head.next);
    }
}   