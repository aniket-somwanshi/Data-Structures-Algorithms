class Solution {
    public long[] findPrefixScore(int[] nums) {
        long currentMax = 0;
        long currentSum = 0;
        
        int n = nums.length;
        long[] res = new long[n];
        
        for (int i = 0; i < n; i++) {
            currentMax = Math.max(currentMax, nums[i]);
            long currentRes = currentSum + currentMax + nums[i];
            res[i] = currentRes;
            currentSum = currentRes;
        }
        
        return res;
    }
}