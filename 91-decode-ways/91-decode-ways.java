class Solution {
    public int numDecodings(String s) {
        s += " ";
        s += " ";
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[n-1] = 1;
        dp[n-2] = 1;
        if (s.charAt(n-3) != '0') dp[n-3] = 1;
        else dp[n-3] = 0;
        
        for (int i = n - 4; i >= 0; i--) {
            if (isValid(s.substring(i, i+1))) {
                dp[i] += dp[i+1];
            }
            if (isValid(s.substring(i, i+2))) {
                dp[i] += dp[i+2];
            } 
        }
        return dp[0];
        
    }
    
    private boolean isValid(String s) {
        // if it contains leading zeros, return false
        if (s.charAt(0) == '0') return false;
        int num = Integer.valueOf(s);
        if (num < 1 || num > 26) return false;
        return true;
    }
}
