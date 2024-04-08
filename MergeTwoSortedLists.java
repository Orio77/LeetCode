

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        boolean end1 = list1 == null;
        boolean end2 = list2 == null;
        ListNode head = null;
        if (end2) {
            return list1;
        }
        else if (end1) {
            return list2;
        }
        // Create head
        if ((!end1 && !end2) && list1.val < list2.val) {
            head = list1;
            if (list1.next != null) {
                list1 = list1.next;
            }
            else {
                end1 = true;
            }
        }
        else if ((!end1 && !end2) && list1.val >= list2.val) {
            head = list2;
            if (list2.next != null) {
                list2 = list2.next;
            }
            else {
                end2 = true;
            }
        }

        ListNode current = head;
        // Keep merging the lists
        while (!end1 && !end2) {
            if (list1.val < list2.val) {
                current.next = list1;
                if (list1.next != null) {
                    list1 = list1.next;
                }
                else {
                    end1 = true;
                }
            }
            else {
                current.next = list2;
                if (list2.next != null) {
                    list2 = list2.next;
                }
                else {
                    end2 = true;
                }
            }
            current = current.next;
        }
        // Copy list2
        if (!end2) {
            current.next = list2;
        }
        // Copy list1
        else if (!end1) {
            current.next = list1;
        }
        // Return head
        return head;
    }
}