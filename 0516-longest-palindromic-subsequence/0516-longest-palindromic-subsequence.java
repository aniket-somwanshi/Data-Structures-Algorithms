class Solution {
    Integer[][] memo;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        memo = new Integer[n][n];
        return getLongestBetween(0, n-1, s);
    }
    
    private int getLongestBetween(int i, int j, String s) {
        if (i >= s.length() || j < 0 || i > j) return 0;
        if (memo[i][j] != null) return memo[i][j];
        if (i == j) {
            return memo[i][j] = 1;
        }
        int equal = 0;
        if (s.charAt(i) == s.charAt(j)) {
            equal = 2 + getLongestBetween(i+1, j-1, s);
        }
        
        int combination1 = getLongestBetween(i+1, j, s);
        int combination2 = getLongestBetween(i, j-1, s);
        
        return memo[i][j] = Math.max(equal, Math.max(combination1, combination2));
    }
}