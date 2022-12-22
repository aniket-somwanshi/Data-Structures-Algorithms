// O(N*k*2) O(N*k*2 + N) --memo --topdown -- can be optimized further into tabulation
class Solution {
    int[] a;
    int n;
    Integer[][][] memo;
    public int maxProfit(int k, int[] a) {
        this.a = a;
        n = a.length;
        memo = new Integer[n][k+1][2];
        return f(0, k, 0);
    }
    
    private int f(int i, int k, int needToSell) {
        // base cases
        if (i == n) return 0;
        if (k == 0) return 0;
        
        // caching
        if (memo[i][k][needToSell] != null) return memo[i][k][needToSell];
        
        // exploration
        int res = 0;
        
        if (k > 0) {
            // we have transactions left
            if (needToSell == 1) {
                // we need to sell this guy 
                int candidate1 = a[i] + f(i+1, k-1, 0); // sell this
                int candidate2 = f(i+1, k, needToSell); // skip this
                
                res = Math.max(res, Math.max(candidate1, candidate2));
            }
            else {
                // we need to buy
                int candidate1 = -a[i] + f(i+1, k, 1); // buy this
                int candidate2 = f(i+1, k, needToSell); // skip this
                
                res = Math.max(res, Math.max(candidate1, candidate2));
            }
        }
        else {
            // we dont' have transactions left
            res = 0;
        }
        
        return memo[i][k][needToSell] = res;
    }
}