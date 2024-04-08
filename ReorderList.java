import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) 
            return;
    
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = head;

        while (dummy != null) {
            stack.push(dummy);
            dummy = dummy.next;
        }

        int size = stack.size();
        for (int i = 0; i < size / 2; i++) {
            ListNode temp = stack.pop();
            ListNode next = head.next;
            head.next = temp;
            temp.next = next;
            head = next;
        }

        if (size % 2 == 0) {
            head.next = null;
        } else {
            head.next = stack.pop();
            head.next.next = null;
        }
    }
}