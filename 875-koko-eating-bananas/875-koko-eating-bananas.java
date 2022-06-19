class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        
        // find max 
        int maxi = Integer.MIN_VALUE;
        for (int num: piles) {
            maxi = Math.max(maxi, num);
        }
        
        int upperBound = maxi;
        
        // binary search
        int left = 1;
        int right = upperBound;
        int k = 1;
        while (left <= right) {
            int mid = left + (right - left)/2; 
            if (isPossible(mid, piles, h)) {
                k = mid;
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return k;
    }
    
    private boolean isPossible(int k, int[] piles, int hours) {
        int timeSpent = 0;
        for (int bananas: piles) {
            timeSpent += bananas/k;
            timeSpent += bananas%k != 0 ? 1 : 0;
            if (timeSpent > hours) return false;
        }
        return timeSpent <= hours;
    }
}