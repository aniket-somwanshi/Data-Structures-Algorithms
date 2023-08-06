class Solution {
    Integer[] memo;
    char[] a;
    String s;
    public int numDecodings(String s) {
        this.s = s;
        a = s.toCharArray();
        memo = new Integer[a.length];
        return f(0);
    }
    
    private int f(int i) {
        if (i >= a.length) return 1;
        
        if (memo[i] != null) return memo[i];
        
        // if there's a leading zero, we can't do shit
        if (a[i] == '0') return 0;
        
        int totalWays = 0;
        // try to cut using just first digit
        totalWays += f(i + 1);
        
        // try to cut using first two digits
        if (i+1 < a.length) {
            int number = Integer.parseInt(s.substring(i, i+2));
            if (number <= 26) totalWays += f(i + 2);
        }
        
        return memo[i] = totalWays;
    }
}