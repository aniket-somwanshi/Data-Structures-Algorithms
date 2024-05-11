class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0, j = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != val) {
                k++;
                nums[j] = nums[i];
                j++;
            }
        }
        return k;
    }
}