class Solution {
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new Integer[n][2]; // [index][state] => index: [0,n-1], state: [0,1]
        return getMaxProfit(0, 0, prices);
    }
    
    private int getMaxProfit(int index, int state, int[] prices) {
        if (index == prices.length) return 0;
        
        if (memo[index][state] != null) return memo[index][state];
        
        int profit = 0;
        
        if (state == 0) {
            profit = Math.max(profit, -prices[index] + getMaxProfit(index + 1, 1, prices));
        }
        else {
            profit = Math.max(profit, prices[index] + getMaxProfit(index + 1, 0, prices));
        }
        profit = Math.max(profit, getMaxProfit(index + 1, state, prices));
        
        return memo[index][state] = profit;
    }
}