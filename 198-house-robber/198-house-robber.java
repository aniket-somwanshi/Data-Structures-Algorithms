class Solution {
    // O(N) O(N) (space can be made O(2))
    public int rob(int[] a)  {
        int n = a.length;
        if (n == 1) return a[0];
        if (n == 2) return Math.max(a[0], a[1]);
        int[] dp = new int[n];
        dp[n-1] = a[n-1];
        dp[n-2] = Math.max(a[n-1], a[n-2]);
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(a[i] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
    // O(N), O(2N)
    // recursion + memoization 
//     public int rob(int[] a) {
//         int[] profit = new int[a.length];
//         Arrays.fill(profit, -1);
//         return recur(a, 0, profit);
//     }
    
//     private int recur(int[] a, int i, int[] profit) {
        
//         if (i >= a.length) return 0;
//         if (profit[i] != -1) return profit[i];
//         int first = a[i] + recur(a, i+2, profit);
//         int second = 0; 
//         if ((i+1) < a.length) second = a[i+1] + recur(a, i+3, profit);
//         profit[i] = Math.max(first, second);
//         return profit[i];
//     }
    
    // recursion TLE
//     public int rob(int[] a) {
//         return recur(a, 0);
//     }
    
//     private int recur(int[] a, int i) {
//         if (i >= a.length) return 0;
//         int first = a[i] + recur(a, i+2);
//         int second = 0; 
//         if ((i+1) < a.length) second = a[i+1] + recur(a, i+3);
//         return Math.max(first, second);
//     }
}