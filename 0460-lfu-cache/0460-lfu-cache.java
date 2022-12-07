class DLL {
    DLLNode head;
    DLLNode tail;
    int size;
    public DLL() {
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }
    
    public void addNode(DLLNode node) {
        DLLNode ogFirst = head.next;   
        head.next = node;
        node.prev = head;
        node.next = ogFirst;
        ogFirst.prev = node;
        
        size++;
    }
    
    public void removeNode(DLLNode node) {
        DLLNode delPrev = node.prev;
        DLLNode delNext = node.next;
        
        delPrev.next = delNext;
        delNext.prev = delPrev;
        
        size--;
    }
}
class DLLNode {
    DLLNode prev;
    DLLNode next;
    int val;
    int key;
    int count;
    public DLLNode(int key, int val) {
        this.val = val;
        this.key = key;
        this.count = 1;
    }
    public DLLNode() {
        this.count = 1;
    }
    
}
class LFUCache {
    int capacity;
    Map<Integer, DLLNode> nodeMap; // key -> DLL Node
    Map<Integer, DLL> freqMap; // frequency -> doubly linked list nodes
    int lowestFrequency;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.lowestFrequency = 0;
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        DLLNode targetNode = nodeMap.get(key);
        int valueToReturn = targetNode.val;
        
        // update it's frequency by 1
        updateFrequency(targetNode);
        
        return valueToReturn;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if (nodeMap.containsKey(key)) {
            DLLNode node = nodeMap.get(key);
            node.val = value;
            updateFrequency(node);
        }
        // if the capacity is not full
        else {
            if (nodeMap.size() == capacity) {
                // need to remove one guy cos there's no space
                DLL lowestList = freqMap.get(lowestFrequency);
                DLLNode lastGuy = lowestList.tail.prev;
                // remove it from nodeMap
                nodeMap.remove(lastGuy.key);
                // remove it from the freqList
                lowestList.removeNode(lastGuy);
            }
            // simply add the new guy with count = 1
            lowestFrequency = 1; // we know this for sure cos we're adding freq 1 guy now
            
            // get the min lowest freq list
            if (!freqMap.containsKey(lowestFrequency)) {
                freqMap.put(lowestFrequency, new DLL());
            }
            DLL lowestList = freqMap.get(lowestFrequency);
            
            // create the node to be added
            DLLNode newNode = new DLLNode(key, value);
            lowestList.addNode(newNode);
            // update in nodeMap
            nodeMap.put(key, newNode);
            // freqMap.put(lowestFrequency, lowestList)
        }
    }
    
    private void updateFrequency(DLLNode node) {
        int originalFrequency = node.count;
        // remove node from current freqList
        DLL targetList = freqMap.get(originalFrequency);
        // remove it from this list
        targetList.removeNode(node);
        
        // if the list from which this node was removed, is empty now
        // increase the lowestFrequency, it lowesFreq List was emptied
        if (lowestFrequency == originalFrequency && targetList.size == 0) {
            lowestFrequency++;
        }
        
        // add it in new freq list
        int newFrequency = originalFrequency + 1;
        
        // add the node in the newFreq list
        if (!freqMap.containsKey(newFrequency)) {
            freqMap.put(newFrequency, new DLL());
        }
        DLL newFrequencyList = freqMap.get(newFrequency);
        
        // add node at first
        node.count = newFrequency;
        newFrequencyList.addNode(node);
        // freqMap.put(newFrequency, newFrequencyList)
        
        // update node map 
        nodeMap.put(node.key, node);
    }
    
    private int getCurrentSize() {
        return nodeMap.size();
    }
    
    private boolean isListEmpty(int frequency) {
        return !freqMap.containsKey(frequency) || freqMap.get(frequency) == null; 
    }
}
