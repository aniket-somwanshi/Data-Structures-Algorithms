// O(N*M) O(N*M) --dp 
// Find LCS. Whatever characters that are not in LCS, need to be deleted
class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int totalLength = n+m;
        
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
        
        int longestCommonLength = dp[n][m];
    
        return totalLength - 2*longestCommonLength;
    }
}