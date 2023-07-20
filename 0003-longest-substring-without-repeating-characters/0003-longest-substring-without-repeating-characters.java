class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int maxiLength = 0;
        int r = 0;
        int l = 0;
        int[] freq = new int[256];
        while (r < n) {
            freq[a[r]]++;
            if (!isValid(freq)) {
                while (!isValid(freq)) {
                    freq[a[l]]--;
                    l++;
                }
            }
            maxiLength = Math.max(maxiLength, r - l + 1);
            r++;
        }
        return maxiLength;
    }
    
    private boolean isValid(int[] freq) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 1) return false;
        }
        return true;
    }
}