// O(N*100) O(N+N)
class Solution {
    Integer[] memo;
    int n;
    public int numSquares(int n) {
        this.n = n;
        memo = new Integer[n+1];
        return f(n);
    }
    
    private int f(int n) {
        // base case
        if (n == 0) return 0;
        
        // memo
        if (memo[n] != null) return memo[n];
        
        // explore
        int mini = Integer.MAX_VALUE;
        for (int num=(int)Math.sqrt(n); num >= 1; num--) {
            mini = Math.min(mini, 1 + f(n-(num*num)));
        }
        return memo[n] = mini;
    }
}