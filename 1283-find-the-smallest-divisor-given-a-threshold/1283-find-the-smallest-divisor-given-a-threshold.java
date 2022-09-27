class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1;
        int right = getMax(nums);
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (isPossible(mid, nums, threshold)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    
    private boolean isPossible(int divisor, int[] nums, int t) {
        for (int i = 0; i < nums.length && t >= 0 ; i++) {
            t -= (int)Math.ceil((double)nums[i]/(double)divisor);
        }
        return t >= 0;
    }    
    private int getMax(int[] a) {
        int maxi = 0;
        for (int num: a) maxi = Math.max(maxi, num);
        return maxi;
    }
}