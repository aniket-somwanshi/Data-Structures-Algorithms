class Solution {
    // O(N + N-1) O(1)
    // count(sum = k) = count(sum <= k) - count(sum <= k-1)
    // this works if our criteria (here sum) is gonna increase or stay the same, if we add a new element
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumUpto(nums, goal) - numSubarraysWithSumUpto(nums, goal-1);
    }
    
    private int numSubarraysWithSumUpto(int[] a, int goal) {
        if (goal < 0) return 0;
        int res = 0;
        int currentSum = 0;
        int start = 0;
        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            while (currentSum > goal) {
                currentSum -= a[start];
                start++;
            }
            res += i - start + 1;
        }
        return res;
    }
}