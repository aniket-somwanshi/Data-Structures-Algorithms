class Solution {
    // O(N) O(1) 
    public boolean canJump(int[] nums) {
        int maxi = 0;
        int mini = 0;
        while (mini <= maxi && maxi < nums.length-1) {
            maxi = Math.max(maxi, mini + nums[mini]);
            mini++;
        }
        
        return maxi >= nums.length-1;
    }
}