class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        int longestLength = 0;
        
        prefix[0] = nums[0] == 1 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] == 1 ? prefix[i-1] + 1 : 0;        
        }
        
        suffix[n-1] = nums[n-1] == 1 ? 1 : 0;
        for (int i = n-2; i >= 0; i--) {
            suffix[i] = nums[i] == 1 ? suffix[i+1] + 1 : 0;     
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int left = i-1 >= 0 ? prefix[i-1] : 0;
                int right = i+1 < n ? suffix[i+1] : 0;
                longestLength = Math.max(longestLength, left + right);
            }
        }
        
        if (longestLength == 0) {
            longestLength = Math.max(0, prefix[n-1]-1);
        }
        
        return longestLength;
    }
}