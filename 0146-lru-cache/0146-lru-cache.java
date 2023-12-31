class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;
    
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Map<Integer, ListNode> map; // <key, node>
    ListNode first;
    ListNode last;
    int size;
    int capacity;
    
    public LRUCache(int capacity) {
        first = new ListNode(-1,-1);    
        last = new ListNode(-1,-1);
        first.next = last;
        last.prev = first;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    private void addToFront(ListNode node) {
        ListNode oldSecond = first.next;
        first.next = node;
        node.prev = first;
        node.next = oldSecond;
        oldSecond.prev = node;
    }
    
    private void removeFromBack() {
        if (size == 0) {
            System.out.println("no element there to delete");
            return;
        }
        map.remove(last.prev.key);
        ListNode secondLast = last.prev.prev;
        last.prev = secondLast;
        secondLast.next = last;
        size--;
    }
    
    public int get(int key) {
        // get the val 
        if (!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        int resVal = node.val;
        
        // detach node
        ListNode nextNode = node.next;
        ListNode prevNode = node.prev;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        
        // attach it to the front
        addToFront(node);
        
        return resVal;
    }
    
    public void put(int key, int value) {
        // if key doesn't exist
        // then create and attach it to the front
        if (!map.containsKey(key)) {
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            addToFront(node);
            size++;
            
            // if the size exceeds the limit
            // remove the last node
            if (size > capacity) {
                removeFromBack();
            }
        }
        // if key exists
        // update the value 
        else {
            ListNode node = map.get(key);
            node.val = value;
            
            // detach node
            ListNode nextNode = node.next;
            ListNode prevNode = node.prev;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            
            // add to front
            addToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */