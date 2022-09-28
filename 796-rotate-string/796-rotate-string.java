class Solution {
    // O(2N) O(2N) -- KMP pattern matching algo
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        s = s + s;
        int[] lps = getLPS(goal);
        
        // goal = pattern (needle)
        // s = haystack
        int i = 0; // haystack
        int j = 0; // goal
        while (i < s.length()) {
            if (s.charAt(i) == goal.charAt(j)) {
                i++;
                j++;
            }
            else {
                if (j == 0) {
                    i++;
                }
                else {
                    j = lps[j - 1];      
                }
            }
            
            if (j == goal.length()) return true;
        }
        return false;
    }
    
    private int[] getLPS(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        int[] lps = new int[n];
        
        int prevPrefixEnd = 0;
        int i = 1;
        
        while (i < n) {
            if (a[i] == a[prevPrefixEnd]) {
                lps[i] = prevPrefixEnd + 1;
                prevPrefixEnd++;
                i++;
            }
            else {
                if (prevPrefixEnd == 0) {
                    lps[i] = 0;
                    i++;
                }
                else {
                    prevPrefixEnd = lps[prevPrefixEnd - 1];        
                }
            }
        }
        return lps;
    }
}