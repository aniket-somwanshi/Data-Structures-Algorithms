// O(N*AMT) O(AMT) -- dp
class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount+1];
        dp[0] = 0;
        
        for (int amt = 1; amt <= amount; amt++) {
            int mini = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (amt - coins[i] >= 0) {
                    int candidate = dp[amt - coins[i]];
                    if (candidate != Integer.MAX_VALUE) {
                        mini = Math.min(mini, 1 + candidate);
                    }
                }
            }
            dp[amt] = mini;
        }
        
        int res = dp[amount];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private int getMinCoins(int amount, int[] coins, Integer[] memo) {
        if (amount < 0) return Integer.MAX_VALUE;
        if (amount == 0) return 0;
        if (memo[amount] != null) return memo[amount];
        
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int candidate = getMinCoins(amount - coins[i], coins, memo);
            if (candidate != Integer.MAX_VALUE) mini = Math.min(mini, 1 + candidate);
        }
        
        return memo[amount] = mini;
    }
}

// // O(N*AMT) O(AMT+AMT)
// class Solution {
//     Integer[] memo;
//     public int coinChange(int[] coins, int amount) {
//         memo = new Integer[amount+1];
//         int res = getMinCoins(amount, coins, memo);
//         return res == Integer.MAX_VALUE ? -1 : res;
//     }
    
//     private int getMinCoins(int amount, int[] coins, Integer[] memo) {
//         if (amount < 0) return Integer.MAX_VALUE;
//         if (amount == 0) return 0;
//         if (memo[amount] != null) return memo[amount];
        
//         int mini = Integer.MAX_VALUE;
//         for (int i = 0; i < coins.length; i++) {
//             int candidate = getMinCoins(amount - coins[i], coins, memo);
//             if (candidate != Integer.MAX_VALUE) mini = Math.min(mini, 1 + candidate);
//         }
        
//         return memo[amount] = mini;
//     }
// }