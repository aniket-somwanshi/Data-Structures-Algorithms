// O(N^2) O(N)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        // if the longest palindrom is of size 1,
        // it can definitely be a[0]
        // so this becomes our base answer
        String[] res = new String[1];
        res[0] = String.valueOf(s.charAt(0));
        for (int i = 0; i < n; i++) {
            expandFromCenter(i, i, s, res);
            expandFromCenter(i, i+1, s, res);
        }
        return res[0];
    }
    
    private void expandFromCenter(int i, int j, String s, String[] res) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if (j-i+1 > res[0].length()) {
                // System.out.println(res);
                res[0] = s.substring(i,j+1);
            }
            i--;
            j++;
        }
    }
}