//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    Integer[][][] memo;
    int longestCommonSubstr(String s1, String s2, int n, int m){
        if (m > n) return longestCommonSubstr(s2, s1, m, n);
        int[][] dp = new int[n+1][m+1];
        
        int res = 0;
        
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                    res = Math.max(res, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }
}

// // O(N*M*M) O(N*M*M) -- memoization TLE
// class Solution{
//     Integer[][][] memo;
//     int longestCommonSubstr(String S1, String S2, int n, int m){
//         if (m > n) return longestCommonSubstr(S2, S1, m, n);
        
//         memo = new Integer[n][m][m];
//         return recur(0, 0, 0, S1, S2, n, m);
//     }
    
//     private int recur(int i, int j, int currentMaxLength, String s1, String s2, int n, int m) {
//         if (i >= n || j >= m) return currentMaxLength;
        
//         if (memo[i][j][currentMaxLength] != null) return memo[i][j][currentMaxLength];
        
//         int continuedMaxLen = currentMaxLength;
//         if (s1.charAt(i) == s2.charAt(j)) {
//             continuedMaxLen = recur(i+1, j+1, currentMaxLength+1, s1, s2, n, m);
//         }
        
//         int maxLen1 = recur(i+1, j, 0, s1, s2, n, m);
//         int maxLen2 = recur(i, j+1, 0, s1, s2, n, m);
    
//         return memo[i][j][currentMaxLength] = Math.max(continuedMaxLen, Math.max(maxLen1, maxLen2));
//     }
// }