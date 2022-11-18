// O(N*AMOUNT) O(2*AMOUNT) --dp space opt
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] up = new int[amount+1];
        int[] current = new int[amount+1];
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if (j == 0) {
                    current[j] = 1;
                }
                else if (coins[i-1] <= j){
                    current[j] = up[j] + current[j-coins[i-1]];
                }
                else {
                    current[j] = up[j];
                }
            }
            up = current;
        }
        
        return up[amount];
    }
}

// // O(N*AMOUNT) O(N*AMOUNT) --dp
// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[][] dp = new int[n+1][amount+1];
        
//         for (int i = 1; i < n+1; i++) {
//             for (int j = 0; j < amount+1; j++) {
//                 if (j == 0) {
//                     dp[i][j] = 1;
//                 }
//                 else if (coins[i-1] <= j){
//                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
//                 }
//                 else {
//                     dp[i][j] = dp[i-1][j];
//                 }
//             }
//         }
        
//         return dp[n][amount];
//     }
// }