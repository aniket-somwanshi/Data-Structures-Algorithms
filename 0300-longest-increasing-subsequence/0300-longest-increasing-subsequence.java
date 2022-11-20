class Solution {
    // O(N*N) O(N*N) --memo
    // pick the current element if it extends current LIS,
    // also skip current element
    public int lengthOfLIS(int[] a) {
        int n = a.length;
        Integer[][] memo = new Integer[n][n];
        
        return recur(0, -1, a, memo);
    }
    
    private int recur(int i, int prevIndex, int[] a, Integer[][] memo) {
        if (i == a.length) return 0;
        
        if (prevIndex != -1 && memo[i][prevIndex] != null) return memo[i][prevIndex];  
        
        int take = 0;
        // take if possible  
        if (prevIndex == -1 || a[i] > a[prevIndex]) {
            take = 1 + recur(i+1, i, a, memo);
        }
        
        // not take
        int notTake = recur(i+1, prevIndex, a, memo);
        
        int res = Math.max(take, notTake);
        if (prevIndex != -1) memo[i][prevIndex] = res;
        return res;
    }
} 


// class Solution {
//     // O(N^2) O(N)
//     // DP
//     // Start from starting index to see if it extend previous lcs
//     public int lengthOfLIS(int[] a) {
//         int n = a.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         int maxi = 1;
//         dp[n-1] = 1;
//         for (int i = n-2; i >= 0; i--) {
//             for (int j = i+1; j < n; j++) {
//                 if (a[j] > a[i]) {
//                     dp[i] = Math.max(dp[i], 1 + dp[j]);
//                 }
//             }
//             maxi = Math.max(maxi, dp[i]);
//         }
//         return maxi;
//     }
// } 
    // O(N^2) O(N)
    // Recursion backtracking
    // memoization
    // cache stores length of longest inc subsequence starting at i
//     public int lengthOfLIS(int[] input) {
//         int max = Integer.MIN_VALUE;
//         int [] cache = new int [input.length];
//         for (int i = 0; i < input.length; ++i) {
//             max = Math.max(max, lengthOfLIS(input,i, cache));
//         }
//         return Math.max(1,max);
//     } 

//     private static int lengthOfLIS(int[] input, int start, int [] cache) {

//         if (start >= input.length) return 0;
//         if (cache[start] != 0) return cache[start];

//         int max = Integer.MIN_VALUE;
//         for (int i = start; i < input.length; ++i) {
//             if (input[i] > input[start]) {
//                 max = Math.max(max,1 + lengthOfLIS(input, i, cache));
//             }
//         }
//         cache[start] = Math.max(max,1);
//         return cache[start];
//     }
// }