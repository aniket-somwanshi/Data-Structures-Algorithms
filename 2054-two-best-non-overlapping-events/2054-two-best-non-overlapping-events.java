class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int maxi = events[0][2];
        for (int[] event: events) maxi = Math.max(maxi, event[2]);
        
        Arrays.sort(events, (x,y) -> x[1]-y[1]);
        
        int[] maxiPrefix = new int[n];
        maxiPrefix[0] = events[0][2];
        
        for (int i = 1; i < n; i++) {
            maxiPrefix[i] = Math.max(maxiPrefix[i-1], events[i][2]);
            
            int recentValidIndex = bs(events, events[i][0], i);
            
            maxi = Math.max(maxi, recentValidIndex >= 0 ? events[i][2] + maxiPrefix[recentValidIndex] : 0);
        }
        
        return maxi;
    }
    
    private int bs(int[][] events, int target, int idx) {
        // find the largest index having events[i][1] < target
        int left = 0;
        int right = idx;
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            
            if (events[mid][1] < target) {
                left = mid + 1;
            }
            else right = mid-1;
        }
        
        return right;
    }
}