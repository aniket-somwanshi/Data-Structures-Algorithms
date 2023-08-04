// O(N) O(N)
class Solution {
    Integer[] memo = new Integer[46];
    public int climbStairs(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;
        
        if (memo[n] != null) return memo[n];
        
        return memo[n] = climbStairs(n-1)+climbStairs(n-2); 
    }
}