class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0 || nums.length == 1) return true;
        
        int lastOneWastAt = Integer.MIN_VALUE;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (lastOneWastAt != Integer.MIN_VALUE && i - lastOneWastAt - 1 < k) return false;
                lastOneWastAt = i;
            }  
        }
        
        return true;
    }
}