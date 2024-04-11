import java.util.Stack;



class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        // Create a stack
        Stack<ListNode> stack = new Stack<>();

        // While Stack's size is less than k, keep adding nodes
        ListNode curr = head;
        ListNode prev = null;
        boolean headSet = false;

        while (true) {
            while (stack.size() < k) {
                // If the next pointer is null return the head
                if (curr == null) {
                    return head;
                }
    
                stack.add(curr);
                curr = curr.next;
            }
    
            // Save the stack.peek.next node to continue later on
            ListNode nextt = stack.peek().next;
            if (prev != null) {
                prev.next = stack.peek();
            }
            if (!headSet) {
                head = stack.peek();
                headSet = true;
            }
    
            // While the stack is not empty, keep popping the nodes and changing the next pointers
            while (!stack.isEmpty()) {
                curr = stack.pop();
                if (!stack.isEmpty()) {
                    curr.next = stack.peek();
                }
            }
            // Set the last node's pointer to the saved node earlier
            curr.next = nextt;
            prev = curr;
            curr = nextt;
            // Repeat the process
        }
    }
}