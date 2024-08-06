package Day19;


class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(head!=null && temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;
            }
        }
        return head;
    }
}