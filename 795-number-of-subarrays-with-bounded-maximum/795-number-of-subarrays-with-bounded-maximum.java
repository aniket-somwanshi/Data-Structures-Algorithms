class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int totalCount = 0;
        int prevCount = 0;
        int start = 0;
        int end = 0;
        while (end < n) {
            if (left <= nums[end] && nums[end] <= right) {
                int numberOfElementsInRange = end - start + 1;
                prevCount = numberOfElementsInRange;
                totalCount += prevCount;
                end++;
            }
            else if (nums[end] < left) {
                totalCount += prevCount;
                end++;
            }
            else if (right < nums[end]) {
                start = end+1;
                prevCount = 0;
                end++;
            }
        }
        return totalCount;
    }
}