//142.Linked List Cycle II
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
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        //A list with 0 or 1 node cannot contain a loop
        if(head == null || head.next == null){
            return null;
        }
        
        //locate meeting point
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        
        //if there is no neeting point
        //(loop not contains), return null.
        if(fast == null || fast.next == null){
            return null;
        }
        
        //The most exciting part! 
        //m: head->loop_start n:cycle length 
        //x: loop_start->meeting point y: meeting point->loop_start
        //We have 2(m+x) = m+kn+x => m = k(n-1) + y
        // where k is a positive integer.
        //It means if two pointers goes simultaneously 
        //from head and meeting point, they'll finally 
        //meet at loop_start node.
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}