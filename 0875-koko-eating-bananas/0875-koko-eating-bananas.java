class Solution {
    // O(logN) O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1;
        // find max
        int maxi = 0;
        for (int pile: piles) maxi = Math.max(maxi, pile);
        // max speed needed
        int right = maxi;
        
        // binary search to find smallest speed 'k'
        // that eats all bananas withing 'h' hours
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (isValid(mid, piles, n, h)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    
    private boolean isValid(int speed, int[] piles, int n, int h) {
        int i = 0;
        for (; i < n && h >= 0; i++) {
            //System.out.print(h+" ");
            h -= piles[i] <= speed ? 1 : (int)Math.ceil((double)piles[i]/(double)speed);
        }
        boolean f = h>=0;
        //System.out.println(speed + "-" + f);
        return h >= 0 && i == n;
    }
}