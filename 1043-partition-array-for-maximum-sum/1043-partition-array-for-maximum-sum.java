class Solution {
    int[] a;
    int n;
    int k;
    Integer[][] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.a = arr;
        this.n = a.length;
        this.k = k;
        this.memo = new Integer[n][n];
        
        return f(0, n-1);
    }
    
    private int f(int i, int j) {
        // base case
        if (i > j) return 0;
        
        if (i == j) return a[i];
        
        if (memo[i][j] != null) return memo[i][j];
        
        int maxi = 0;
        
        int res = 0;
        
        for (int ind = i; ind - i + 1 <= k && ind <= j; ind++) {
            // partition at ind
            maxi = Math.max(maxi, a[ind]);
            int candidate =  (maxi * (ind - i + 1)) + f(ind+1, j);
            res = Math.max(res, candidate);
        }
        
        return memo[i][j] = res;
    }
}