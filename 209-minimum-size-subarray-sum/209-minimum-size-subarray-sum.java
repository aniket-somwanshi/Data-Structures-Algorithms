class Solution {
    public int minSubArrayLen(int target, int[] a) {
        int mini = Integer.MAX_VALUE;
        int i = 0;
        int current_sum = 0;
        int n = a.length;
        int start = 0;
        while (i < n) {
            current_sum += a[i];
            // look for better answers if sum is valid
            while (current_sum >= target) {
                mini = Math.min(mini, i - start + 1);
                current_sum -= a[start];
                start++;
            }
            i++;
        }
        
        
        if (mini == Integer.MAX_VALUE) return 0;
        return mini;
    }
}