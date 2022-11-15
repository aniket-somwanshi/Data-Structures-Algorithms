// O(N) O(1) dp space optimized
class Solution {
    public int climbStairs(int n) {
        int last = 1;
        int secondLast = 1;
        for (int i = 2; i <= n; i++) {
            int current = last + secondLast;
            secondLast = last;
            last = current;
        }
        return last;
    }
}

// // O(N) O(N) dp
// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         dp[0] = dp[1] = 1;
//         for (int i = 2; i <= n; i++) {
//             dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[n];
//     }
// }

// // O(N) O(N+N) memo
// class Solution {
//     Integer[] memo;
//     public int climbStairs(int n) {
//         memo = new Integer[n+1];
//         return findWays(n);
//     }
    
//     private int findWays(int n) {
//         if (n <= 1) return 1;
//         if (memo[n] != null) return memo[n];
//         return memo[n] = climbStairs(n-1) + climbStairs(n-2);
//     }
// }

// // O(2^N) O(N) recursion
// class Solution {
//     public int climbStairs(int n) {
//         if (n <= 1) return 1;
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
// }