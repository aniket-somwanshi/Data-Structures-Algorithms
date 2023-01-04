class Solution {
    // O(N*M) O(1)
    public int minDeletionSize(String[] strs) {
        int res = 0;
        int n = strs[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strs.length-1; j++) {
                if (strs[j].charAt(i) > strs[j+1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}