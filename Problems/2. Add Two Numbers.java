/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Dummy head is useful in LList! It reduces the process of LL head
        ListNode dummyHead = new ListNode(0);
        //operate on dummyhead so do not need to deal with edge case
        ListNode curr = dummyHead;
        int sum = 0;
        //list not traversed completely or carry-over needed
        while(l1 != null || l2 != null || sum > 0){
            //calculate sum
            sum += (l1 == null? 0 : l1.val) + (l2 == null? 0 : l2.val);
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            //mod 10 to see carry
            sum /= 10;
        }
        
        return dummyHead.next;
    }
}