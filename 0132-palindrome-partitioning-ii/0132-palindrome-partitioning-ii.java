// O(N^2 + N^2) O(N^2 + N^2) -- dp -- bottom up 
class Solution {
    int n;
    char[] a;
    boolean[][] isPalindrome;
    // Integer[] memo;
    public int minCut(String s) {
        this.a = s.toCharArray();
        n = a.length;
        
        this.isPalindrome = getPalindromes();
        
        // this.memo = new Integer[n];
        int[] dp = new int[n+1];
        
        
        
        // base case
        dp[n] = 0;
        
        
        for (int i = n-1; i >= 0; i--) {
            // base case
            
            if (isPalindrome[i][n-1]) {
                dp[i] = 0;
                continue;
            }
            
            int res = Integer.MAX_VALUE;
        
            for (int k = i; k < n; k++) {
                if (isPalindrome[i][k]) {
                    res = Math.min(res, 1 + dp[k+1]);
                }
            }

            dp[i] = res;
            
        }
        
        return dp[0];    
        
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


// // O(N^2 + N^2) O(N^2 + N^2 + N) -- memo -- top down 
// class Solution {
//     int n;
//     char[] a;
//     boolean[][] isPalindrome;
//     Integer[] memo;
//     public int minCut(String s) {
//         this.a = s.toCharArray();
//         n = a.length;
        
//         this.isPalindrome = getPalindromes();
        
//         this.memo = new Integer[n];
//         return f(0);    
        
//     }
    
//     private int f(int i) {
//         // base case
//         if (i == n) return 0;
        
//         if (isPalindrome[i][n-1]) return 0;
        
//         // caching 
//         if (memo[i] != null) return memo[i];
        
//         // exploration
//         int res = Integer.MAX_VALUE;
        
//         for (int k = i; k < n; k++) {
//             if (isPalindrome[i][k]) {
//                 res = Math.min(res, 1 + f(k+1));
//             }
//         }
        
//         return memo[i] = res;
//     }
    
    
    
//     private boolean[][] getPalindromes() {
//         boolean[][] dp = new boolean[n][n];
        
//          for (int offset = 0; offset < n; offset++) {
//              for (int i = 0, j = i + offset; j < n; j++, i++) {
//                  if (i == j) dp[i][j] = true;
//                  else if (offset == 1) dp[i][j] = a[i] == a[j];
//                  else dp[i][j] = a[i] == a[j] && dp[i+1][j-1];
//              }
            
//          }
        
        
//         return dp;
//     }
    
// }