class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] output = new int[(n-k)+1];
        int outputIndex = 0;
        
        int left = 0;
        int right = 0;
        
        Deque<Integer> dq = new LinkedList<>(); // stores indices
        
        while (right < n) {
            // before inserting a[right], make sure the 
            // useless values that are lesser than it,
            // from the right side of the dq, are removed
            // cos they will never be a max of any window anymore
            // as, to their right, we have this bigger value
            // which is a candidate for being the max 
            while (!dq.isEmpty() && a[dq.peekLast()] < a[right]) {
                dq.pollLast();
            }
            
            // now we can insert the value at right
            dq.addLast(right);
            
            // if we are shifting our window forward to the right,
            // left index will no longer be in consideration innit
            // so if in our dq(which represents our window)
            // if we have an index at the start which is no longer in window,
            // remove it
            if (dq.peekFirst() < left) {
                dq.pollFirst();
            }
            
            // if we have processed at least k elements,
            // this is our window
            if (right + 1 >= k) { // +1 for 0-based indices
                // for this window what is our max
                // it's the leftmost guy in the dq
                // as we have maintained the dq to be decreasing order
                // so get it and put in the output
                output[outputIndex++] = a[dq.peekFirst()];
                
                // here, we know that we had a k sized window,
                // so move the window forward
                left++;
            }
            // move right every step, even thought we don't have k elements yet
            right++;
        }
        
        return output;
    }
}