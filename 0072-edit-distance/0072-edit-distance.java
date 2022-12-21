// O(N*M) O(N*M + N) -- dp bottom up
class Solution {
    char[] s1;
    char[] s2;
    int n;
    int m;
    public int minDistance(String word1, String word2) {
        s1 = word1.toCharArray();
        s2 = word2.toCharArray();
        n = s1.length;
        m = s2.length;
        int[][] dp = new int[n+1][m+1];
        
        // base case
        for (int j = 0; j < m+1; j++) {
            dp[n][j] = m-j;
        }
        for (int i = 0; i < n+1; i++) {
            dp[i][m] = n-i;
        }
        
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                int res = Integer.MAX_VALUE;
        
                int c1 = dp[i][j+1];
                c1 = c1 == Integer.MAX_VALUE ? Integer.MAX_VALUE : c1 + 1;

                int c2 = dp[i+1][j];
                c2 = c2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : c2 + 1;

                int c3 = dp[i+1][j+1];
                c3 = c3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : c3 + 1;

                int c4 = Integer.MAX_VALUE;
                c4 = s1[i] == s2[j] ? dp[i+1][j+1] : c4;

                res = Math.min(c1, Math.min(c2, Math.min(c3, c4)));
                
                dp[i][j] = res;
            }
        }
        
        return dp[0][0];
    }
    
   
}


// // O(N*M) O(N*M + N) -- memo top down
// class Solution {
//     char[] s1;
//     char[] s2;
//     int n;
//     int m;
//     Integer[][] memo;
//     public int minDistance(String word1, String word2) {
//         s1 = word1.toCharArray();
//         s2 = word2.toCharArray();
//         n = s1.length;
//         m = s2.length;
//         memo = new Integer[n][m];
//         return f(0, 0);
//     }
    
//     private int f(int i, int j) {
//         // base case
//         if (j == m) return n-i; // delete remaining
//         if (i == n) return m-j; // insert remaining
        
//         // caching
//         if (memo[i][j] != null) return memo[i][j];
        
//         // exploration 
//         int res = Integer.MAX_VALUE;
        
//         int c1 = f(i, j+1);
//         c1 = c1 == Integer.MAX_VALUE ? Integer.MAX_VALUE : c1 + 1;
        
//         int c2 = f(i+1, j);
//         c2 = c2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : c2 + 1;
        
//         int c3 = f(i+1, j+1);
//         c3 = c3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : c3 + 1;
        
//         int c4 = Integer.MAX_VALUE;
//         c4 = s1[i] == s2[j] ? f(i+1, j+1) : c4;
        
//         res = Math.min(c1, Math.min(c2, Math.min(c3, c4)));
        
//         return memo[i][j] = res;
//     }
// }