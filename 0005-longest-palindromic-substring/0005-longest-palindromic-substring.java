class Solution {
    int maxLength = 0;
    int bestI = 0;
    int bestJ = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n-1; i++) {
            getPalindromeLength(s, i, i+1);
            getPalindromeLength(s, i+1, i+1);
        }
        return s.substring(bestI, bestJ+1);
    }
    
    private void getPalindromeLength(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                if (j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    bestI = i;
                    bestJ = j;
                }
                i--; j++;
            }
            else break;
            
        }
    }
}