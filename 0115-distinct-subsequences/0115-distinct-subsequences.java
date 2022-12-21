class Solution {
    char[] s1;
    char[] s2;
    int n;
    int m;
    Integer[][] memo;
    public int numDistinct(String s, String t) {
        s1 = s.toCharArray();
        s2 = t.toCharArray();
        n = s1.length;
        m = s2.length;
        
        if (m > n) return 0;
        
        memo = new Integer[n][m];
        
        return f(0,0);
    }
    
    private int f(int i, int j) {
        // base cases
        if (j == m) return 1;
        if (i == n) return 0;
        
        if (memo[i][j] != null) return memo[i][j];
        
        // explore
        int res = 0;
        
        // matching
        if (s1[i] == s2[j]) res += f(i+1, j+1);
        
        // need to move s1
        res += f(i+1, j);
        
        return memo[i][j] = res;
    }
}