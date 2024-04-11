import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        Queue<ListNode> nodes = new PriorityQueue<>(Comparator.comparing(l -> l.val));
        ListNode dummy = null;
        for (ListNode listNode : lists) {
            dummy = listNode;
            while (dummy != null) {
                nodes.add(dummy);
                dummy = dummy.next;
            }
        }
        
        ListNode head = nodes.poll();
        dummy = head;

        while (!nodes.isEmpty()) {
            dummy.next = nodes.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    }
}