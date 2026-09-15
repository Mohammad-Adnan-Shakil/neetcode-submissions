class Solution {
    public void reorderList(ListNode head) {
        // Step 1 - find middle
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2 - reverse second half
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(second != null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // Step 3 - merge alternating
        ListNode first = head;
        second = prev;
        while(second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}