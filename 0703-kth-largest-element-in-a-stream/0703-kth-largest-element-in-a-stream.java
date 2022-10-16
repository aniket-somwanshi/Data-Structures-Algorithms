class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    // O(N*logK) O(k)
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num: nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }
    }
    
    // O(2logK)
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */