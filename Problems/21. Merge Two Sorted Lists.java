//21. Merge Two Sorted Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //dummyhead is so brillant! You don't even need to 
        //spend time dealing with real head nodes of l1 and l2
        ListNode h = new ListNode(0); 
        ListNode ans = h;
        //compare val and add them to ans in sorted order
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                h.next = l1;
                l1 = l1.next;
            }else{
                h.next = l2;
                l2 = l2.next;
            }
            h = h.next;
        }

        //the rest nodes must be all greater than 
        //the last node in current ans
        if(l1 != null){
            h.next = l1;
        }
        
        if(l2 != null){
            h.next = l2;
        }
        
        //remember, skip dummyhead!
        return ans.next;
    }
}
