class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // move fast n+1 steps ahead
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        // move both until fast hits end
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        // remove nth node
        slow.next = slow.next.next;

        return dummy.next;
    }
}