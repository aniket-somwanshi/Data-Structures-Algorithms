class Solution {
    // O(N + N-1) O(1)
    // count(odds = k) = count(odds <= k) - count(odds <= k-1)
    // this works if our criteria (here number of odds) is gonna increase or stay the same, if we add a new element
    public int numberOfSubarrays(int[] nums, int k) { 
        return numSubarraysWithOddsUpto(nums, k) - numSubarraysWithOddsUpto(nums, k-1);
    }
    
    private int numSubarraysWithOddsUpto(int[] a, int goal) {
        if (goal < 0) return 0;
        int res = 0;
        int currentOdds = 0;
        int start = 0;
        for (int i = 0; i < a.length; i++) {
            currentOdds += a[i] % 2 == 1 ? 1 : 0;
            while (currentOdds > goal) {
                currentOdds -= a[start] % 2 == 1 ? 1 : 0;
                start++;
            }
            res += i - start + 1;
        }
        return res;
    }
}