class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0 ; i < nums.length ; i++) {
        if (nums[i] == target) {
            return i;
        }
    }
    

    int j = 0;
    for (int i = 0 ; i < nums.length ; i++) {
        if (nums[i] > target) {
            return i;  
        }
           j++; 
    }
    return j;
    }
}