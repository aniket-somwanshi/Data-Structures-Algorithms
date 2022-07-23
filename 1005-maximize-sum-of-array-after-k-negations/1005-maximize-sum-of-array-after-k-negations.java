class Solution {
    // O(2*NlogN + N) O(N)
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < k) {
                if (nums[i] < 0) {
                    nums[i] = -1 * nums[i];
                    count++;
                }
            }
        }
        if (count < k) {
            Arrays.sort(nums);
            while (count < k) {
                nums[0] = -1 * nums[0];
                count++;
            }
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum; 
    }
}