class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
                else if (coins[i-1] <= j && dp[i][j-coins[i-1]] < Integer.MAX_VALUE){
                   dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][amount] == Integer.MAX_VALUE ? -1 : dp[n][amount];
    }
}