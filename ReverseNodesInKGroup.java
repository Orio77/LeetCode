import java.util.Stack;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Kol sol = new Kol();

        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;


        sol.reverseKGroup(head, 2);
        showList(head);
    }

    public static void showList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
    }
}


class Kol {
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