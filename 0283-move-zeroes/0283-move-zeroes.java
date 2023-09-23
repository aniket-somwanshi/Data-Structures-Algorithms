class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
            right++;
        }
        while (left < n) {
            nums[left++] = 0;
        }
    }
}