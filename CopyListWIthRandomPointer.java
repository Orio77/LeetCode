
// Definition for a Node.

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class MySolution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node dummy = head;
        Node copyHead = getNode(head);
        Node copyDummy = copyHead;

        while (dummy.next != null) {
            copyDummy.next = getNode(dummy.next);
            dummy = dummy.next;
            copyDummy = copyDummy.next;
        }
        return copyHead;
    }

    public Node getNode(Node original) {
        Node copied = new Node(original.val);
        copied.next = original.next;
        copied.random = original.random;
        return copied;
    }
}

class MySolution2 {
    public Node copyRandomList(Node head) {
        return getNode(head);
    }

    public Node getNode(Node original) {
        if (original == null) {
            return null;
        }
        if (original.next == null) {
            Node copied = new Node(original.val);
            copied.next = null;
            copied.random = getNode(original.random);
        }
        if (original.random == null) {
            Node copied = new Node(original.val);
            copied.next = getNode(original.next);
            copied.random = null;
            return copied;
        }
        Node copied = new Node(original.val);
        copied.next = getNode(original.next);
        copied.random = getNode(original.random);
        return copied;
    }
}

class MySolution3 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node dummy = head;
        Node copyHead = new Node(head.val);
        Node copyDummy = copyHead;

        while (dummy.next != null) {
            copyDummy.next = new Node(dummy.next.val);
            dummy = dummy.next;
            copyDummy = copyDummy.next;
        }

        dummy = head;
        copyDummy = copyHead;


        return copyHead;
    }
}

class Solution {
    public Node copyRandomList(Node head) {

        Map<Node, Node> oldToCopy = new HashMap<>();
        Node cur = head;

        while (cur != null) {
            oldToCopy.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            Node copy = oldToCopy.get(cur);
            copy.next = oldToCopy.get(cur.next);
            copy.random = oldToCopy.get(cur.random);
            cur = cur.next;
        }

        return oldToCopy.get(head);
    }
}