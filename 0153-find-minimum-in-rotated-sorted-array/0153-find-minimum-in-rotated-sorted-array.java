class Solution {
    // O(logN) O(1)
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int left = 0;
        int right = n-1;
        if (nums[left] < nums[right]) return nums[left];
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[mid+1]) return nums[mid+1];
            if (nums[mid-1] > nums[mid]) return nums[mid];
            
            else if (nums[mid] > nums[left]) {
                left = mid+1;
            }
            else {
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}