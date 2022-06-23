class Solution {
    public int rob(int[] a) {
        int n = a.length;
        if (n == 1) return a[0];
        if (n == 2) return Math.max(a[0], a[1]);
        if (n == 3) return Math.max(a[0], Math.max(a[1], a[2]));
        int[] dp = new int[n];
        
        dp[n-1] = a[n-1];
        dp[n-2] = Math.max(a[n-1], a[n-2]);
        
        int temp = a[0];
        a[0] = 0;
        
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(a[i] + dp[i+2], dp[i+1]);
        }
        int first = dp[0];
        
        a[n-1] = 0;
        a[0] = temp;
        
        dp[n-1] = a[n-1];
        dp[n-2] = Math.max(a[n-1], a[n-2]);        
        
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(a[i] + dp[i+2], dp[i+1]);
        }
        
        return Math.max(dp[0], first);
    }
}
// [1,2,3,1,1,2,3,1]
//  8,7,7,4,4,3,3,1 
