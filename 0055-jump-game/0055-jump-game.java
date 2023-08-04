class Solution {
    public boolean canJump(int[] nums) {
        int maxCoverageIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxCoverageIndex < i) return false;
            maxCoverageIndex = Math.max(maxCoverageIndex, i + nums[i]);
        }
        return true;
    }
}