class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if (nums.length == 0) return new int[] {-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) return new int[] {0, 0};
            else return new int[] {-1, -1};
        }
        
        
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (target <= nums[mid]) {
                high = mid - 1;
            }
            else low = mid + 1;
        }
        int first = low;
        if (first < 0 || first >= nums.length || nums[first] != target) first = -1;
        
        low = 0;
        high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (target >= nums[mid]) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        int second = high;
        if (second < 0 || second >= nums.length || nums[second] != target) second = -1;
        
        return new int[] {first, second};
    }
}