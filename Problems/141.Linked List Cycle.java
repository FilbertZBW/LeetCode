    
//141.Linked List Cycle 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //list without node or with only one node won't have cycle
        if(head == null || head.next == null){
            return false;
        }
       //Initialize slow and fast pointer
        //This is a brillant idea! If fast and slow meet each other, 
        //it means a loop exists.
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}