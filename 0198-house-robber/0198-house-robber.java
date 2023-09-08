// O(N) O(2)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        
        int next = 0; // dp[n] = 0;
        int nextNext = 0; // dp[n+1] = 0;
        
        for (int i = n-1; i>=0; i--) {
            int ans = Math.max(nums[i] + nextNext, next);
            nextNext = next;
            next = ans;
        }
        return next;
    }
}


// // O(N) O(N)
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n+2];
        
//         dp[n] = 0;
//         dp[n+1] = 0;
        
//         for (int i = n-1; i>=0; i--) {
//             dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
//         }
//         return dp[0];
//     }
// }

// // O(N) O(N+N)
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         Integer[] memo = new Integer[n];
//         return f(0, nums, memo);
//     }
    
//     private int f(int i, int[] nums, Integer[] memo) {
//         if (i >= nums.length) return 0;
//         if (memo[i] != null) return memo[i];
//         return memo[i] = Math.max(nums[i] + f(i+2, nums, memo), f(i+1, nums, memo));
//     }
// }