package Day29;

// User function Template for Java

/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node divide(Node head) {
        // Initialize pointers for even and odd lists
        Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;
        
        // Traverse the linked list
        Node current = head;
        while (current != null) {
            if (current.data % 2 == 0) { // Check if the node is even
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else { // The node is odd
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }
        
        // If there are no even nodes, return the odd list
        if (evenStart == null) {
            return oddStart;
        }

        // Connect the even list to the odd list
        evenEnd.next = oddStart;

        // If there are odd nodes, make sure the last odd node points to null
        if (oddEnd != null) {
            oddEnd.next = null;
        }

        // Return the head of the even list which is now the modified list
        return evenStart;
    }
}