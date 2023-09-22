class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>(); // Deque<Index>
        // calculate the first window manually
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && a[dq.peekLast()] < a[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        // we maintain the dq in monotonically decreasing order
        // max element in the window is always the first element in dq
        res[0] = a[dq.peekFirst()];
        
        for (int i = 1; i < n-k+1; i++) {
            // one element just went out of bounds so remove it from left
            // if it's there at all
            if (dq.peekFirst() < i) dq.pollFirst();
            
            int newElementIndex = i+k-1;
            // insert the new element, to make sure the mono decreasing
            // state is maintained, remove anyone who's lesser than the current
            // element from the end of queue
            // We can remove those cos they'd never contribute to max going forward
            // cos the current superior element will cockblock them innit
            while (!dq.isEmpty() && a[dq.peekLast()] < a[newElementIndex]) {
                dq.pollLast();
            }
            dq.addLast(newElementIndex);
            // all the elements in dq are that in the valid window boundary
            // all the elements in dq are decreasing order
            // so the first element is the current window's max
            res[i] = a[dq.peekFirst()];
        }
        
        return res;
    }
}