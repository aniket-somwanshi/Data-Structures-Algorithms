// O(2N) O(1)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        int currentMaxSum = 0;
        for (int num: nums) {
            currentMaxSum += num;
            if (currentMaxSum <= 0) {
                currentMaxSum = 0;
            }
            maxi = Math.max(maxi, currentMaxSum);
        }
        
        // flips signs
        for (int i = 0; i < n; i++) nums[i] = nums[i] * (-1);
        
        currentMaxSum = 0;
        
        for (int num: nums) {
            currentMaxSum += num;
            if (currentMaxSum <= 0) {
                currentMaxSum = 0;
            }
            maxi = Math.max(maxi, currentMaxSum);
        }
        
        
        return maxi;
    }
}