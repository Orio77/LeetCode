import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * MergeKSortedLists
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        K sol = new K();
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(-1);
        ListNode node3 = new ListNode(-1);
        ListNode node4 = new ListNode(-2);
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;
        ListNode[] lists = new ListNode[]{node4, null};

        sol.mergeKLists(lists);
    }
    
}


class K {
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