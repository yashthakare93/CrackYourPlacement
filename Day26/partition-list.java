package Day26;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallList = new ListNode(0);
        ListNode bigList = new ListNode(0);
        ListNode small = smallList;
        ListNode big = bigList;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigList.next;
        big.next = null;

        return smallList.next;
    }
}