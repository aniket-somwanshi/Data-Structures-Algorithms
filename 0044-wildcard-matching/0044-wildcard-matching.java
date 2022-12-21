// O(N*M) O(N*M) -- dp --bottom up 
class Solution {
    char[] s1;
    char[] s2;
    int n;
    int m;
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        s1 = p.toCharArray();
        s2 = s.toCharArray();
        n = s1.length;
        m = s2.length;
        boolean[][] dp = new boolean[n+1][m+1];
        
        // base case 
        for (int i = 0; i < n+1; i++) {
            int index = i;
            while (index < n && s1[index] == '*') index++;
            dp[i][m] = index == n;
        }
        dp[n][m] = true; 
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                boolean res = false;
        
                if (s1[i] == '*') {
                    res = res | dp[i][j+1];
                    res = res | dp[i+1][j]; 
                }
                else if (s1[i] == '?') {
                    res = res | dp[i+1][j+1];
                }
                else {
                    res = res | s1[i] == s2[j] ? dp[i+1][j+1] : false;
                }

                dp[i][j] = res;
            }
        }
    
        return dp[0][0];
    }
    
    private boolean f(int i, int j) {
        if (i == n) return j == m;
        if (j == m) {
            int index = i;
            while (i < n && s1[i] == '*') i++;
            return i == n;
        }
        
        boolean res = false;
        
        if (s1[i] == '*') {
            if (f(i,j+1)) return memo[i][j] = true;
            if (f(i+1, j)) return memo[i][j] = true;
        }
        else if (s1[i] == '?') {
            res = res | f(i+1, j+1);
        }
        else {
            res = res | s1[i] == s2[j] ? f(i+1, j+1) : false;
        }
        
        return memo[i][j] = res;
    }
}

// // O(N*M) O(N*M + N) -- memo --top down-- TLE !!
// class Solution {
//     char[] s1;
//     char[] s2;
//     int n;
//     int m;
//     Boolean[][] memo;
//     public boolean isMatch(String s, String p) {
//         s1 = p.toCharArray();
//         s2 = s.toCharArray();
//         n = s1.length;
//         m = s2.length;
//         memo = new Boolean[n][m];
//         return f(0,0);
//     }
    
//     private boolean f(int i, int j) {
//         if (j == m) {
//             int index = i;
//             while (index < n && s1[index] == '*') index++;
//             return index == n;
//         }
//         if (i == n) return j == m;
        
        
//         boolean res = false;
        
//         if (s1[i] == '*') {
//             if (f(i,j+1)) return memo[i][j] = true;
//             if (f(i+1, j)) return memo[i][j] = true;
//         }
//         else if (s1[i] == '?') {
//             res = res | f(i+1, j+1);
//         }
//         else {
//             res = res | s1[i] == s2[j] ? f(i+1, j+1) : false;
//         }
        
//         return memo[i][j] = res;
//     }
// }