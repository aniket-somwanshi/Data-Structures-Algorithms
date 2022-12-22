// O(N*3*2) O(N*3*2 + N) --memo --topdown -- can be optimized further into tabulation
class Solution {
    int[] a;
    int n;
    Integer[][] memo;
    int fee;
    public int maxProfit(int[] a, int fee) {
        this.a = a;
        n = a.length;
        this.fee = fee;
        memo = new Integer[n][2];
        return f(0, 0);
    }
    
    private int f(int i, int needToSell) {
        // base cases
        if (i == n) return 0;
        
        // caching
        if (memo[i][needToSell] != null) return memo[i][needToSell];
        
        // exploration
        int res = 0;
        

        // we have transactions left
        if (needToSell == 1) {
            // we need to sell this guy 
            int candidate1 = -fee + a[i] + f(i+1, 0); // sell this
            int candidate2 =  f(i+1, needToSell); // skip this

            res = Math.max(res, Math.max(candidate1, candidate2));
        }
        else {
            // we need to buy
            int candidate1 = -a[i] + f(i+1, 1); // buy this
            int candidate2 = f(i+1, needToSell); // skip this

            res = Math.max(res, Math.max(candidate1, candidate2));
        }
       
        
        return memo[i][needToSell] = res;
    }
}