class Solution {
    private Integer[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][nums2.length];
        return recur(0, 0, nums1, nums2);
    }
    
    private int recur(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) return 0;
        
        if (dp[i][j] != null) return dp[i][j];
        
        int ans = 0;
        if (nums1[i] == nums2[j]) {
            ans = 1 + recur(i+1, j+1, nums1, nums2);
        }
        else {
            ans = Math.max(recur(i+1, j, nums1, nums2), recur(i, j+1, nums1, nums2));
        }
        return dp[i][j] = ans;
    }
}