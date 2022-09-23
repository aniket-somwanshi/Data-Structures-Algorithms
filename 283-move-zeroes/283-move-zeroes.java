class Solution {
    // O(N) O(1)
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) zeros++;
        }
        int currectPosition = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[currectPosition] = nums[i];
                currectPosition++;
            }    
        }
        System.out.println(zeros);
        int index = n-1;
        while (zeros-- > 0) {
            nums[index--] = 0;
        }
    }
}