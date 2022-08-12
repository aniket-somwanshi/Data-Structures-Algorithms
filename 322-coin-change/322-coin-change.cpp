class Solution {
public:
//     int coinChange(vector<int>& a, int t) {
// //         int min_cnt = INT_MAX;
// //         int n = a.size();
// //         int dp[t+1];
        
// //         for(int j = 0; j < t+1; j++){
// //               dp[j] =  t +1;  
// //         }
// //         dp[0] = 0;
// //         for(int i = 1; i <= t; i++){
// //             for(int j = 0; j < a.size(); j++){
               
// //                 if(a[j] <= i){
// //                     dp[i] = min(dp[i],1 + dp[i-a[j]]);     
// //                 }
                           
// //             }
// //         }
// //         if(dp[t]>t){
// //             return -1;
// //         }
// //     else{
// //         return dp[t];}
// //     }
        
        
//         vector<long> dp (t+1, INT_MAX);
//         dp[0] = 0;
//         for(int i = 0; i < dp.size(); i++){
//             for(int j = 0; j < a.size(); j++){
//                 if(i >= a[j]){
//                     dp[i] = min(dp[i],1 + dp[i-a[j]]);
//                 }
//             }
//         }
//         if(dp[t]==INT_MAX) return -1;
//         return dp[t];
        
//     }
    int coinChange(vector<int>& a, int t) {
        int n = a.size();
        long dp[n+1][t+1];
        
        for (int j = 1; j <= t; j++) dp[0][j] = t+1;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                if (a[i-1] > j) {
                    // coin is bigger than amount to be made
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-a[i-1]]);
                }
            }
        }
        if (dp[n][t] > t) return -1;
        return dp[n][t];
    }
};