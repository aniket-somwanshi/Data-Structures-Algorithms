// O(N*M) O(N*M + min(N,M)) --memo 
// delete if not same, don't delete if same, get minimum deletions
class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        Integer[][] memo = new Integer[n][m];
        
        return recur(0, 0, s1, s2, memo);
    }
    
    private int recur(int i, int j, String s1, String s2, Integer[][] memo) {
        // base case
        if (i >= s1.length() && j >= s2.length()) return 0;
        if (i >= s1.length()) return s2.length() - j;
        if (j >= s2.length()) return s1.length() - i;
        
        if (memo[i][j] != null) return memo[i][j];
        
        // equal
        int equal = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j)) {
            equal = recur(i+1, j+1, s1, s2, memo);
        }
        
        // shift s1
        int shiftS1 = 1 + recur(i+1, j, s1, s2, memo);
        
        // shift s2
        int shiftS2 = 1 + recur(i, j+1, s1, s2, memo);
        
        return memo[i][j] = Math.min(equal, Math.min(shiftS1, shiftS2));
    }
}

// // O(N*M) O(N*M) --dp 
// // Find LCS. Whatever characters that are not in LCS, need to be deleted
// class Solution {
//     public int minDistance(String s1, String s2) {
//         int n = s1.length();
//         int m = s2.length();
//         int totalLength = n+m;
        
//         int[][] dp = new int[n+1][m+1];
        
//         for (int i = 0; i < n+1; i++) {
//             for (int j = 0; j < m+1; j++) {
//                 if (i == 0 || j == 0) dp[i][j] = 0;
//                 else {
//                     int equal = s1.charAt(i-1) == s2.charAt(j-1) ? 1 + dp[i-1][j-1] : 0;
//                     int deleteFromS1 = dp[i-1][j];
//                     int deleteFromS2 = dp[i][j-1];
                    
//                     dp[i][j] = Math.max(equal, Math.max(deleteFromS1, deleteFromS2));
//                 }
//             }
//         }
        
//         int longestCommonLength = dp[n][m];
    
//         return totalLength - 2*longestCommonLength;
//     }
// }