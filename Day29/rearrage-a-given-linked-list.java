package Day29;

class Solution {
    void reorderlist(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // Step 1: Find the middle of the list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        Node prev = null, curr = slow, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Step 3: Merge the two halves
        Node first = head, second = prev;
        while (second.next != null) {
            Node tmp1 = first.next;
            Node tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}