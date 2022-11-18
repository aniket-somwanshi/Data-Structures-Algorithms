class Solution {
    int offset = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        for (int num: nums) offset += num; 
        Integer[][] memo = new Integer[n][2*offset+1];
        for (Integer[] m: memo) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        return recur(0, 0, nums, target, memo);
    }
    
    private int recur(int i, int currentSum, int[] nums, int target, Integer[][] memo) {
        if (i == nums.length) {
            if (currentSum == target) {
                return 1;
            }
            else return 0;
        }  
        
        if (memo[i][currentSum+offset] != Integer.MAX_VALUE) return memo[i][currentSum+offset];
        
        // 2 choices
        int positive = recur(i+1, currentSum + nums[i], nums, target, memo);
        
        int negative = recur(i+1, currentSum - nums[i], nums, target, memo);
        
        return memo[i][currentSum+offset] = positive + negative;
    }
}
    