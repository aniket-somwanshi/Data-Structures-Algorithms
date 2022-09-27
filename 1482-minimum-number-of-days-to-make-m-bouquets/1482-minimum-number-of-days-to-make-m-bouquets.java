class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // bloomDay[i]: this flower is available from this day onwards
        // m: number of bouquets needed
        // k: adjacent flowers needed for a single bouquet
        // days: number of days we have waited
        
        // if number of flowes we have are less than that we need
        if (bloomDay.length <  m * k) return -1;
        
        int left = 1;
        int right = getMax(bloomDay);
        
        // binary search to get the minumum waiting days that gives us required bouquets
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (isValid(mid, bloomDay, m, k)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    
    private boolean isValid(int days, int[] bloomDay, int m, int k) {
        int currentFlowers = 0;
        for (int i = 0; i < bloomDay.length && m > 0; i++) {
            if (bloomDay[i] <= days) {
                currentFlowers++;
                if (currentFlowers == k) {
                    m--;
                    currentFlowers = 0;
                }
            }
            else {
                currentFlowers = 0;
            }
        }
        return m == 0;
    }
    
    private int getMax(int[] a) {
        int maxi = Integer.MIN_VALUE;
        for (int num: a) maxi = Math.max(maxi, num);
        return maxi;
    }
    
}