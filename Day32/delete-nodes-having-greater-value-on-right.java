package Day32;


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution {
    Node compute(Node head) {
        // Step 1: Reverse the linked list
        head = reverse(head);
        
        // Step 2: Traverse the reversed list and remove nodes that are smaller than max encountered so far
        Node current = head;
        Node maxNode = head;
        Node temp;
        
        while (current != null && current.next != null) {
            if (current.next.data < maxNode.data) {
                // Remove the next node
                temp = current.next;
                current.next = temp.next;
            } else {
                // Update the maxNode and move to the next node
                current = current.next;
                maxNode = current;
            }
        }
        
        // Step 3: Reverse the list again to restore original order
        head = reverse(head);
        
        return head;
    }

    // Helper function to reverse a linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}