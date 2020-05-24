//Four steps:
//pre-step: a pointer on original list(curr), a pointer to newList(newCurr)
//1. Check whether curr has been copied. If not, create a copy of curr node and put in the map
//2. Check whether curr.random is copied. If not, create copy & put in map.
//3. Store random in curr.copy, then add curr.copy to the newlist.
//4. For every node in original list, repeat 123.

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        
        Node curr = head;
        Node dummyHead = new Node(0);
        Node newCurr = dummyHead;
        Map<Node, Node> map = new HashMap<>();
        
        while(curr != null){
            if(!map.containsKey(curr)){
                map.put(curr, new Node(curr.val));
            }
            
            newCurr.next = map.get(curr);
            
            if(curr.random != null){
                if(!map.containsKey(curr.random)){
                    map.put(curr.random, new Node(curr.random.val));
                }
                newCurr.next.random = map.get(curr.random);
            }
            
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return dummyHead.next;
    }
}
