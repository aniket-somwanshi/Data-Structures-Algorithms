class Solution {
    public int splitArray(int[] a, int m) {
        // precomputations
        int n = a.length;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for (int num: a) {
            sum += num;
            maxi = Math.max(maxi, num);
        }
        
        // binary search on "max sum in single partition"
        int low = maxi;
        int high = sum;
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            
            if (isPossible(a, n, mid, m)) {
                high = mid - 1;
            }
            else low = mid + 1; 
        }
        return low;
    }
    
    private boolean isPossible(int[] a, int n, int maxSumAllowed, int maxPartitionsAllowed) {
        int currentPartitions = 1;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > maxSumAllowed) return false;
            
            if (currentSum + a[i] > maxSumAllowed) {
                currentPartitions++;
                currentSum = a[i]; // reset and initialize 
                
                if (currentPartitions > maxPartitionsAllowed) return false;
            }
            else {
                currentSum += a[i];
            }
        }
        return currentPartitions <= maxPartitionsAllowed;
    }
}