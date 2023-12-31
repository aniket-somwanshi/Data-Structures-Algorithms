// O(1) O(N)
class LFUCache {
    Map<Integer, ListNode> keyMap;
    Map<Integer, DoublyLinkedList> countMap;
    int miniCount;
    int size;
    int capacity;
    
    public LFUCache(int capacity) {
        keyMap = new HashMap<>();
        countMap = new HashMap<>();
        miniCount = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (keyMap.containsKey(key)) {
            ListNode node = keyMap.get(key);
            markAsUsed(node);
            return node.val;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (keyMap.containsKey(key)) {
            ListNode node = keyMap.get(key);
            node.val = value;
            markAsUsed(node);
        }
        else {
            ListNode node = new ListNode(key, value);
            keyMap.put(key, node);
            
            if (size == capacity) {
                // get the mininum count's dll
                DoublyLinkedList dll = countMap.get(miniCount);
                ListNode nodeToBeRemoved = dll.removeLast();
                keyMap.remove(nodeToBeRemoved.key);
                size--;
            }
            
            miniCount = 1;
            DoublyLinkedList dll = countMap.getOrDefault(1, new DoublyLinkedList());
            dll.addNode(node);
            size++;
            countMap.put(1, dll);
        }
    }
    
    private void markAsUsed(ListNode node) {
        DoublyLinkedList oldList = countMap.get(node.count);
        oldList.remove(node);
        
        if (oldList.size == 0 && miniCount == node.count) {
            miniCount++;
        }
        
        node.count++;
        
        DoublyLinkedList newList = countMap.getOrDefault(node.count, new DoublyLinkedList());
        newList.addNode(node);
        countMap.put(node.count, newList);
    }
}

class DoublyLinkedList {
    ListNode head;
    ListNode tail;
    int size;
    
    public DoublyLinkedList() {
        head = new ListNode(1,1);
        tail = new ListNode(1,1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public void addNode(ListNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
        size++;
    }

    public ListNode removeLast() {
        if (size == 0) {
            System.out.println("Nothing there to delete");
            return null;
        }
        ListNode lastNode = tail.prev;
        remove(lastNode);
        return lastNode;
    }

    public void remove(ListNode node) {   
        ListNode nextNode = node.next;
        ListNode prevNode = node.prev;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
    
}

class ListNode {
    int key;
    int val;
    int count;
    ListNode next;
    ListNode prev;
    
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.count = 1;
    }
}