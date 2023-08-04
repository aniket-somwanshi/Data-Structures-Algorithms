class Solution {
    char[] s;
    char[] p;
    Boolean[][] memo;
    public boolean isMatch(String S, String P) {
        s = S.toCharArray();
        p = P.toCharArray();
        memo = new Boolean[s.length][p.length];
        return f(0, 0);
    }
    
    private boolean f(int i, int j) {
        // base
        if (j == p.length) {
            return i == s.length;
        }
        if (i == s.length) {
            // check if only *s are left in p
            for (int index = j; index < p.length; index++) {
                if (p[index] != '*') return false;
            }
            return true;
        }
        
        // memo
        if (memo[i][j] != null) return memo[i][j];
        
        // explore
        boolean res = false;
        
        if (p[j] == '*') {
            res = res | f(i, j+1);
            res = res | f(i+1, j);
        }
        else if (p[j] == '?') {
            res = res | f(i+1, j+1);
        }
        else {
            res = res | (s[i] == p[j] && f(i+1, j+1));
        }
        
        // return
        return memo[i][j] = res;
    }
}