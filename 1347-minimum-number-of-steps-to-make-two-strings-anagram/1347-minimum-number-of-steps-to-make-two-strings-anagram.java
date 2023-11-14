// O(N) O(N)
class Solution {
    public int minSteps(String s, String t) {
        int extras = 0;
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        
        for (char c: s.toCharArray()) {
            freqS[c-'a']++;
        }
        for (char c: t.toCharArray()) {
            freqT[c-'a']++;
        }
        
        for (char c='a'; c <= 'z'; c++) {
            if (freqT[c-'a'] > freqS[c-'a']) {
                extras += freqT[c-'a'] - freqS[c-'a'];
            }
        }
        
        return extras;
     }
}