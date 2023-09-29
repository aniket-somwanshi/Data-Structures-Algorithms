class Solution {
    Integer[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount+1];
        int res = getMinCoins(amount, coins, memo);
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