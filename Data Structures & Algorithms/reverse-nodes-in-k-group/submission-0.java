class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // check if k nodes exist
        ListNode curr = head;
        int count = 0;
        while(curr != null && count < k){
            curr = curr.next;
            count++;
        }
        if(count < k) return head; // less than k nodes left, don't reverse

        // reverse k nodes
        ListNode prev = null;
        curr = head;
        for(int i = 0; i < k; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // head is now tail of reversed group
        // connect to next reversed group recursively
        head.next = reverseKGroup(curr, k);

        return prev; // prev is new head of reversed group
    }
}