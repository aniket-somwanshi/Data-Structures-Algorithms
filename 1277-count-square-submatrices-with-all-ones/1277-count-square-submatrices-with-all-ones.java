// O(N*N) O(N*N) --dp --cant be made space O(N)
class Solution {
    public int countSquares(int[][] a) {
        int r = a.length;
        int c = a[0].length;
        
        int res = 0;
        
        for (int i = r-1; i >= 0; i--) {
            for (int j = c-1; j >= 0; j--) {
                if (a[i][j] == 0) continue;
                
                int right = j + 1 < c ? a[i][j+1] : 0;
                int down = i + 1 < r ? a[i+1][j] : 0;
                int diagonal = j + 1 < c && i + 1 < r ? a[i+1][j+1] : 0;
                
                a[i][j] = Math.min(diagonal, Math.min(down, right)) + 1;
                
                res += a[i][j];
            }
        }
        
        return res;
    }
    
    
// // O(N*N) O(N*N) --dp --cant be made space O(N)
// class Solution {
//     public int countSquares(int[][] a) {
//         int n = a.length;
//         int m = a[0].length;
//         int[][] dp = new int[n][m];
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (i == 0 || j == 0) dp[i][j] = a[i][j];
//                 else if (a[i][j] == 0) dp[i][j] = 0;
//                 else {
//                     dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
//                 }
//             }
//         }
        
//         int res = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 res += dp[i][j];
//             } 
//         }
//         return res;
//     }
}