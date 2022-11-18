class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else {
                    int equal = s1.charAt(i-1) == s2.charAt(j-1) ? 1 + dp[i-1][j-1] : 0;
                    int deleteFromS1 = dp[i-1][j];
                    int deleteFromS2 = dp[i][j-1];
                    
                    dp[i][j] = Math.max(equal, Math.max(deleteFromS1, deleteFromS2));
                }
            }
        }
        return dp[n][m];
    }
}





// class Solution {
//     // O(N*M) O(N*M) 
//     // DP
//     // each cell represents lcs starting at from that index
//     public int longestCommonSubsequence(String s1, String s2) {
//         int size1 = s1.length();
//         int size2 = s2.length();
//         int[][] lcs = new int[size1+1][size2+1];
//         // fill zeros for out of bounds 
//         // as if one of the string is "" then common subsequence will be 0 length
//         for (int j = 0; j < size2+1; j++) {
//             lcs[size1][j] = 0;
//         }
//         for (int i = 0; i < size1+1; i++) {
//             lcs[i][size2] = 0;
//         }
        
//         // fill lcs 
//         for (int i = size1-1; i >= 0; i--) {
//             for (int j = size2-1; j >= 0; j--) {
//                 // if matches, lcs is 1 + excluding current chars from both strings
//                 if (s1.charAt(i) == s2.charAt(j)) {
//                     lcs[i][j] = 1 + lcs[i+1][j+1];
//                 }
//                 else {
//                     // if not match, lcs is either excluding current char from s1 or from s2
//                     lcs[i][j] = Math.max(lcs[i+1][j], lcs[i][j+1]);
//                 }
//             }
//         } 
        
//         return lcs[0][0];
        
        
//     }
    // TLE : recursion 
//     public int longestCommonSubsequence(String s1, String s2) {
//         int size1 = s1.length();
//         int size2 = s2.length();
        
//         return lcs(0, 0, size1, size2, s1, s2);
//     }
    
//     private int lcs(int index1, int index2, int size1, int size2, String s1, String s2) {
//         if (index1 >= size1) return 0;
//         if (index2 >= size2) return 0;
        
//         if (s1.charAt(index1) == s2.charAt(index2)) {
//             return 1 + lcs(index1 + 1, index2 + 1, size1, size2, s1, s2);
//         }
//         else {
//             return Math.max(lcs(index1, index2 + 1, size1, size2, s1, s2),
//                            lcs(index1 + 1, index2, size1, size2, s1, s2));
//         }
//     }
//}