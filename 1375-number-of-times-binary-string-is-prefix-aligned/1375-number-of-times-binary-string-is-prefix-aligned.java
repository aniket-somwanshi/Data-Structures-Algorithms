class Solution {
    public int numTimesAllBlue(int[] flips) {
        int rightMost = 0;
        int res = 0;
        for (int i = 0; i < flips.length; i++) {
            rightMost = Math.max(flips[i], rightMost);
            if (rightMost == i+1) res++;
        }
        return res;
    }
}