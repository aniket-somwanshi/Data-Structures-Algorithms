class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Integer[] memo = new Integer[n];
        return f(0, nums, memo);
    }
    
    private int f(int i, int[] nums, Integer[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] != null) return memo[i];
        return memo[i] = Math.max(nums[i] + f(i+2, nums, memo), f(i+1, nums, memo));
    }
}