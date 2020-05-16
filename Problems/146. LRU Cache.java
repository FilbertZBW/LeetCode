//We need a list-like structure to store our caches. However,
//In order to implement this in O(1) time, we still need a map that
//stores the reference corresponding to each node in the list.
//When get() method is called, we should move the called node to the
//head of the list. When put() is called, we put it into the head since
//it is the most recently visited. Some edge cases are also included
//in this implementation to pass the test.

class LRUCache {
    private int cachCapacity;
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> map;
    
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }
    
    public LRUCache(int capacity) {
        this.cachCapacity = capacity;
        map = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            remove(node);
            node.value = value;
            add(node);
        }else {
            if(map.size() == cachCapacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            add(newNode);
        }
    }    
    
    private void add(Node node){
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    private void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */