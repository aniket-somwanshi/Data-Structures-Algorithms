class Solution {
    public int findNumberOfLIS(int[] a) {
        int n = a.length;
        int[] LISUntil = new int[n];
        int[] numberOfLISUntil = new int[n];
        for (int i = 0; i < n; i++) {
            LISUntil[i] = 1;
            numberOfLISUntil[i] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            int maxi = 1;
            for (int prev = 0; prev < i; prev++) {
                if (a[i] > a[prev]) {
                    if (1 + LISUntil[prev] > maxi) {
                        maxi = 1 + LISUntil[prev];
                        numberOfLISUntil[i] = numberOfLISUntil[prev];
                    }
                    else if (1 + LISUntil[prev] == maxi) {
                        numberOfLISUntil[i] += numberOfLISUntil[prev];
                    }
                }
            }
            LISUntil[i] = maxi;
        }
        
        // find max length LIS
        int maxLen = 0;
        for (int num: LISUntil) {
            maxLen = Math.max(maxLen, num);
        }
        
        int res = 0;
        // add all those with length = maxLen
        for (int i = 0; i < n; i++) {
            if (LISUntil[i] == maxLen) {
                res += numberOfLISUntil[i];
            }
        }
        return res;
    }
}