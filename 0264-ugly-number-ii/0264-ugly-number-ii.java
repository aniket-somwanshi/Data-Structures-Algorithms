class Solution {
    public int nthUglyNumber(int n) {
        int[] pos = {0, 0, 0}; // 2,3,5
        int[] multiplier = {2, 3, 5};
        int[] dp = new int[n];
        int[] tmp = new int[3];
        dp[0] = 1;
        int completePos = 1;
        while (completePos < n) {
            int nextUgly = Integer.MAX_VALUE;
            for (int j = 0; j < multiplier.length; j++) {
                int nextUglyCandidate = multiplier[j] * dp[pos[j]];
                tmp[j] = nextUglyCandidate;
                nextUgly = Math.min(nextUgly, nextUglyCandidate);
            }
            for (int j = 0; j < multiplier.length; j++) {
                if (tmp[j] == nextUgly) {
                    pos[j] += 1;
                }
            }
            dp[completePos++] = nextUgly;
        }
        return dp[n - 1];
    }
}