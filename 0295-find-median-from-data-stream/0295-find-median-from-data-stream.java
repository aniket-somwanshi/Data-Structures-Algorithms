class MedianFinder {
    PriorityQueue<Integer> maxHeap; 
    PriorityQueue<Integer> minHeap; 
    int n;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        n = 0;
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return (double)maxHeap.peek();
        }
        else return (minHeap.peek()+maxHeap.peek())/2.0d;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */