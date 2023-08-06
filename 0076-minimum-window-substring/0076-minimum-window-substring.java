class Solution {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        
        int[] targetFreq = new int[256];
        
        for (char c: t) {
            targetFreq[c]++;
        }
        
        int resI = 0;
        int resJ = 0;
        
        int i = 0;
        int j = 0;
        int minSize = Integer.MAX_VALUE;
        
        int[] currentFreq = new int[256];
        while (j < s.length) {
            currentFreq[s[j]]++;
            while (isValid(currentFreq, targetFreq)) {
                // update res
                if (j-i+1 < minSize) {
                    minSize = j-i+1;
                    resI = i;
                    resJ = j;
                }
                currentFreq[s[i]]--;
                i++;
            }
            j++;
        }
        
        if (minSize == Integer.MAX_VALUE) return "";
        return S.substring(resI, resJ+1);
    }
    
    private boolean isValid(int[] f, int[] t) {
        for (int i = 0; i < 256; i++) {
            if (f[i] < t[i]) return false; 
        }
        return true;
    }
}