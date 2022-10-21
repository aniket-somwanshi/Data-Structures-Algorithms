class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n][n];
        return isValid(s, 0, 0, memo, n);
    }
    
    private boolean isValid(String s, int i, int openings, Boolean[][] memo, int n) {
        if (i == n) return openings == 0;
        if (openings < 0) return false;
        if (memo[i][openings] != null) return memo[i][openings];
        if (s.charAt(i) == '*') {
            if (isValid(s, i+1, openings+1, memo, n)) return memo[i][openings] = true;
            if (isValid(s, i+1, openings-1, memo, n)) return memo[i][openings] = true;
            if (isValid(s, i+1, openings, memo, n)) return memo[i][openings] = true;
        }
        else if (s.charAt(i) == '(') {
            if (isValid(s, i+1, openings+1, memo, n)) return memo[i][openings] = true;
        }
        else {
            if (isValid(s, i+1, openings-1, memo, n)) return memo[i][openings] = true;
        }
        return memo[i][openings] = false;
    }
}