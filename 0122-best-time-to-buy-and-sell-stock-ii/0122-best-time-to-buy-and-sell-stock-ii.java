class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] memo = new Integer[n][2];
        // 0: can buy
        // 1: can sell
        return recur(0, 0, prices, memo);
    }
    
    private int recur(int i, int state, int[] prices, Integer[][] memo) {
        if (i >= prices.length) return 0;
        
        if (memo[i][state] != null) return memo[i][state];
        
        int profit = 0;
        if (state == 0) {
            // buy
            int buyNow = -prices[i] + recur(i+1, 1, prices, memo);
            int buyLater = recur(i+1, 0, prices, memo);
            profit = Math.max(buyNow, buyLater);
        }
        else {
            // sell
            int sellNow = +prices[i] + recur(i+1, 0, prices, memo);
            int sellLater = recur(i+1, 1, prices, memo);
            profit = Math.max(sellNow, sellLater);
        }
        return memo[i][state] = profit;
    }
}