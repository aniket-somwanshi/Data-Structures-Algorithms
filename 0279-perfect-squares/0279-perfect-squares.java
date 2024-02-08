// O(N*100) O(N) --dp
class Solution {
    public int numSquares(int n) {
        Integer[] dp = new Integer[n+1];
        
        dp[0]=0;
        
        for (int i = 1; i <= n; i++) {
            // find what perfect square we can substract from i so as
            // to get closer to 0
            int mini = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                mini = Math.min(mini, 1 + dp[i-(j*j)]);
            }
            dp[i]=mini;
        }
        // while(true){}
        return dp[n];
    }
    

}

// // O(N*100) O(N+N) --memo
// class Solution {
//     Integer[] memo;
//     int n;
//     public int numSquares(int n) {
//         this.n = n;
//         memo = new Integer[n+1];
//         return f(n);
//     }
    
//     private int f(int n) {
//         // base case
//         if (n == 0) return 0;
        
//         // memo
//         if (memo[n] != null) return memo[n];
        
//         // explore
//         int mini = Integer.MAX_VALUE;
//         for (int num=(int)Math.sqrt(n); num >= 1; num--) {
//             mini = Math.min(mini, 1 + f(n-(num*num)));
//         }
//         return memo[n] = mini;
//     }
// }