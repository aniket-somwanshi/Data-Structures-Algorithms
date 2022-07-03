class Solution {
public:
    int uniquePaths(int m, int n) {
    // int dp[m][n];
    // for(int i = m-1; i >= 0; i--){
    //     for(int j = n-1; j >=0 ; j--){
    //         if(i == m-1){
    //             dp[i][j] = 1;
    //         }
    //         else if(j == n-1){
    //             dp[i][j] = 1;
    //         }
    //         else{
    //             dp[i][j] = dp[i][j+1] + dp[i+1][j];
    //         }
    //     }
    // }
    // return dp[0][0];
        
        
        
        // vector<vector<int>> dp(m, vector<int> (n, 1));
        // for(int i = 1; i < m; i++){
        //     for(int j = 1; j < n; j++){
        //         dp[i][j] = dp[i][j-1] + dp[i-1][j];
        //     }
        // }
        // return dp[m-1][n-1];
    
        
        // using combinations
        int N = n-1 + m-1;
        int r = m-1; // or n-1;
        double res = 1;
        for(int i = 1; i <= r; i++){
            res = res * (N - r + i) / i;
        }
        return (int)res;
        
    }
};