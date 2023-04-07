// O(N*STEPS) O(N*STEPS + STEPS) -- memoization  -- MLE!
class Solution {
    private int MOD = 1000000007;
    private int n;
    private Integer[][] memo;
    public int numWays(int steps, int arrLen) {
        this.n = arrLen;
        // this.memo = new Integer[n][steps+1];
        this.memo = new Integer[steps+1][steps+1];
        return f(0, steps);
    }
    
    private int f(int index, int stepsLeft) {
        if (stepsLeft == 0) return index == 0 ? 1 : 0;
        
        if (memo[index][stepsLeft] != null) return memo[index][stepsLeft];
        
        int left = index-1 >= 0 ? f(index-1, stepsLeft-1) : 0;
        int right = index+1 < n ? f(index+1, stepsLeft-1) : 0;
        int stay = f(index, stepsLeft-1);
        
        return memo[index][stepsLeft] = (int)((0L + left + right + stay) % MOD);
    } 
}


// // O(3^STEPS) O(STEPS)
// class Solution {
//     private int n;
//     public int numWays(int steps, int arrLen) {
//         this.n = arrLen;
//         return f(0, steps);
//     }
    
//     private int f(int index, int stepsLeft) {
//         if (stepsLeft == 0) return index == 0 ? 1 : 0;
        
//         int left = index-1 >= 0 ? f(index-1, stepsLeft-1) : 0;
//         int right = index+1 < n ? f(index+1, stepsLeft-1) : 0;
//         int stay = f(index, stepsLeft-1);
        
//         return left + right + stay;
//     } 
// }