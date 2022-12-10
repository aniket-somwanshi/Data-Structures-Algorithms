class MedianFinder {
    PriorityQueue<Integer> leftHalf;
    PriorityQueue<Integer> rightHalf;
    
    public MedianFinder() {
        leftHalf = new PriorityQueue<Integer>((a,b)->b-a); // max heap
        rightHalf = new PriorityQueue<Integer>(); // min heap
    }
    
    public void addNum(int num) {
        // we should always keep the 2 halves balanced
        // in terms of number of elements
        leftHalf.add(num);
        
        if (rightHalf.size() > 0 && leftHalf.peek() > rightHalf.peek()) {
            int wrongInsertion = leftHalf.poll();
            rightHalf.add(wrongInsertion);
        }
        
        // size imbalance
        if (leftHalf.size() > rightHalf.size()+1) {
            int extraElement = leftHalf.poll();
            rightHalf.add(extraElement);
        }
        if (rightHalf.size() > leftHalf.size()+1) {
            int extraElement = rightHalf.poll();
            leftHalf.add(extraElement);
        }
    }
    
    public double findMedian() {
        // if one of them has an extra number, that is the median
        if (leftHalf.size() > rightHalf.size()) {
            return leftHalf.peek();
        }
        else if (rightHalf.size() > leftHalf.size()) {
            return rightHalf.peek();
        }
        else {
            // they are equal so both it's the median of 2 middle numbers
            return (leftHalf.peek() + rightHalf.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */