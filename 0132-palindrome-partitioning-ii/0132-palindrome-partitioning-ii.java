class Solution {
    int n;
    char[] a;
    boolean[][] isPalindrome;
    Integer[] memo;
    public int minCut(String s) {
        this.a = s.toCharArray();
        n = a.length;
        
        this.isPalindrome = getPalindromes();
        
        this.memo = new Integer[n];
        return f(0);    
        
    }
    
    private int f(int i) {
        // base case
        if (i == n) return 0;
        
        if (isPalindrome[i][n-1]) return 0;
        
        // caching 
        if (memo[i] != null) return memo[i];
        
        // exploration
        int res = Integer.MAX_VALUE;
        
        for (int k = i; k < n; k++) {
            if (isPalindrome[i][k]) {
                res = Math.min(res, 1 + f(k+1));
            }
        }
        
        return memo[i] = res;
    }
    
    
    
    private boolean[][] getPalindromes() {
        boolean[][] dp = new boolean[n][n];
        
         for (int offset = 0; offset < n; offset++) {
             for (int i = 0, j = i + offset; j < n; j++, i++) {
                 if (i == j) dp[i][j] = true;
                 else if (offset == 1) dp[i][j] = a[i] == a[j];
                 else dp[i][j] = a[i] == a[j] && dp[i+1][j-1];
             }
            
         }
        
        
        return dp;
    }
    
}