import java.util.HashMap;
import java.util.Map;
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
class MySolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // Create two stacks, one for each list
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        // Create two maps for parents, one for each list
        Map<ListNode, ListNode> parents1 = new HashMap<>();

        // Populate the structures
        parents1.put(l1, null);
        while (l1 != null) {
            stack1.push(l1);
            if (l1.next != null) {
                parents1.put(l1.next, l1);
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        // Get head
        ListNode head = stack1.peek();
        // pop from stacks and add values                  
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode node = stack1.peek();
            int sum = node.val + stack2.peek().val;

            if (sum > 9) {
                node.val = sum % 10;
                ListNode cur = node;
                if (parents1.get(cur) == null) {
                    ListNode newHead = new ListNode(1, head);
                    parents1.replace(head, newHead);
                    parents1.put(newHead, null);
                }
                while (parents1.get(cur).val > 9) { 
                    if (parents1.get(parents1.get(cur)) == null) {
                        ListNode newHead = new ListNode(1, head);
                        parents1.replace(head, newHead);
                        parents1.put(newHead, null);
                        head = newHead;
                        newHead = null;
                    }
                    cur = cur.next;
                }
                if (parents1.get(head) == null) {
                    cur.val++;
                }
            }
            else {
                stack1.pop().val += stack2.pop().val;
            }
        }
        return head;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }
}