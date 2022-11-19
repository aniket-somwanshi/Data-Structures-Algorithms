// assum you have bought already and consider selling on each day
class Solution {
    public int maxProfit(int[] prices) {
        int costPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - costPrice);
            costPrice = Math.min(costPrice, prices[i]);
        }
        return maxProfit;
    }
}