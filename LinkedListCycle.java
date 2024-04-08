import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> visited = new HashSet<>();

        visited.add(head);
        while (head.next != null) {
            ListNode next = head.next;
            if (visited.contains(next)) {
                return true;
            }
            visited.add(next);
            head = head.next;
        }
        return false;
    }
}

// || head.next == null || head.next.next == null

/*
 * public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head ; 
        ListNode fast = head ; 

        while (fast != null && fast.next != null) {
            slow = slow.next ;
            fast = fast.next.next ; 

            if (slow == fast) {
                return true ; 
            }
        }
        return false ;
    }
}
 */