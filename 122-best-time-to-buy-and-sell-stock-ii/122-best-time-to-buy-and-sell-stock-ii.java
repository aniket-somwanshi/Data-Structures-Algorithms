class Solution {
    /*
    O(N) O(1)
    Peak Valley approach
    To get profit we only need to go from valley to a peak
    As the days come one after the other, the profits will add up
    */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int totalProfit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i-1] < prices[i]) {
                totalProfit += prices[i] - prices[i-1];
            }
        }
        return totalProfit;
    }
    
    /*
    O(N^2) O(N)
    DP 
    To choose which day to sell each stock at 
    7 1 5 3 6 4
    - - - - - 0
    We are at 6 what can we do? 
    1)Either we can buy at 6 and try to sell afterwards
    or 
    2)Don't buy at 6 
    1)We buy at 6 and We have an option to sell at 4
    but it's lesser than 6 so let's not go broke
    2)We don't buy at 6 so we take the max possible profit
    as if there was no 6. ie profit at 4
    7 1 5 3 6 4
    - - - - 0 0
    
    We are at 3 
    After buying at 3, we can sell at 6 or we can sell at 4
    Take which ever gives max profit
    
    7 1 5 3 6 4
    - - - 3 0 0
    
    7 1 5 3 6 4
    - - 3 3 0 0
    
    We are at 1
    We can buy at 1 and
    i) sell at 5, getting (5-1) + profit at 5 = 4 + 3 = 7 profit
    ii) sell at 3, getting (3-1) + profit at 3 = 2 + 3 = 5 profit
    ... 
    
    */
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[] maxProfitAt = new int[n];
//         maxProfitAt[n-1] = 0;
        
//         for (int i = n-2; i >= 0; i--) {
//             maxProfitAt[i] = maxProfitAt[i+1];
//             for (int j = i+1; j < n; j++) {
//                 // sell only if it's at higher price
//                 if (prices[j] < prices[i]) continue;
//                 maxProfitAt[i] = Math.max(maxProfitAt[i], prices[j] - prices[i] + maxProfitAt[j]);
//             }
//         }
        
//         return maxProfitAt[0];
//     }
}













