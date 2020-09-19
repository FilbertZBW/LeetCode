class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        for(int i = 1; i < m; i++){
            prev = prev.next;
        }
        
        ListNode curr = prev.next;
        

        //mechanism: all elements after curr 
        //will be moved to the front of curr one by one
        for(int i = m; i < n; i++){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        
        return dummy.next;
    }
}