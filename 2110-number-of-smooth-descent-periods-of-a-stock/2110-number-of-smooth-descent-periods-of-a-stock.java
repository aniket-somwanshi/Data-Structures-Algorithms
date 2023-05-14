class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        int currentStreak = 1;
        long res = 1;
        for (int i = 1; i < n; i++) {
            if (prices[i] == prices[i-1]-1) {
                currentStreak = 1 + currentStreak;
            }
            else {
                currentStreak = 1;
            }
            res += currentStreak;
        }
        return res;
    }
}