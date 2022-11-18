class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        //int[][] dp = new int[n+1][amount+1];
        int[] up = new int[amount+1];
        int[] current = new int[amount+1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (i == 0) {
                    current[j] = Integer.MAX_VALUE;
                }
                else if (coins[i-1] <= j && current[j-coins[i-1]] < Integer.MAX_VALUE){
                    current[j] = Math.min(up[j], 1 + current[j-coins[i-1]]);
                }
                else current[j] = up[j];
            }
            up = current;
        }
        
        return up[amount] == Integer.MAX_VALUE ? -1 : up[amount];
    }
}