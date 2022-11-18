class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                }
                else if (coins[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][amount];
    }
}