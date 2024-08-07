package Day20;

class Solution {
    private static final int MOD = 1000000007;
     private long listToNumber(Node head) {
        long number = 0;
        while (head != null) {
            number = (number * 10 + head.data) % MOD;
            head = head.next;
        }
        return number;
    }

    // Function to multiply two linked lists
    public long multiplyTwoLists(Node l1, Node l2) {
        long num1 = listToNumber(l1);
        long num2 = listToNumber(l2);
        return (num1 * num2) % MOD;
    }


}