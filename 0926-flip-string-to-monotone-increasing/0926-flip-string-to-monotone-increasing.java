// O(N*2) O(N*2) dp bottom up
class Solution {
    char[] a;
    int n;
    public int minFlipsMonoIncr(String s) {
        a = s.toCharArray();
        n = a.length;
        Integer[][] dp = new Integer[n+1][2];
        
        dp[n][0] = 0;
        dp[n][1] = 0;
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                int res = Integer.MAX_VALUE;
                if (j == 1) {
                    if (a[i] == '0') {
                        // it's not matching the rule, so we must flip it
                        res = Math.min(res, 1 + dp[i+1][j]);
                    }
                    else {
                        // it should be a 1 and it is a 1 so no problem
                        res = Math.min(res, dp[i+1][j]);
                    }
                }

                if (j == 0) {
                    if (a[i] == '0') {
                        // it can be a zero, so it's just fine
                        res = Math.min(res, dp[i+1][j]);
                    }
                    else {
                        // it can be a zero, but it's a one

                        // case 1: it's a normal transition from 0s to 1s
                        res = Math.min(res, dp[i+1][1]);

                        // case 2: we want to continue the zeros streak, 
                        // so we make this into a zero, and continue that
                        res = Math.min(res, 1 + dp[i+1][0]);
                    }
                }
                
                dp[i][j] = res;
            }
        
        }
        return dp[0][0];
    }
    
}

// // O(N*2) O(N*2 + N) memo
// class Solution {
//     char[] a;
//     int n;
//     Integer[][] memo;
//     public int minFlipsMonoIncr(String s) {
//         a = s.toCharArray();
//         n = a.length;
//         memo = new Integer[n][2];
//         return f(0, false);
//     }
    
//     private int f(int i, boolean mustBeOne) {
//         if (i == n) return 0;
        
//         int res = Integer.MAX_VALUE;
        
//         if (memo[i][mustBeOne ? 0 : 1] != null) return memo[i][mustBeOne ? 0 : 1];
        
//         if (mustBeOne) {
//             if (a[i] == '0') {
//                 // it's not matching the rule, so we must flip it
//                 res = Math.min(res, 1 + f(i+1, mustBeOne));
//             }
//             else {
//                 // it should be a 1 and it is a 1 so no problem
//                 res = Math.min(res, f(i+1, mustBeOne));
//             }
//         }
        
//         if (!mustBeOne) {
//             if (a[i] == '0') {
//                 // it can be a zero, so it's just fine
//                 res = Math.min(res, f(i+1, mustBeOne));
//             }
//             else {
//                 // it can be a zero, but it's a one
                
//                 // case 1: it's a normal transition from 0s to 1s
//                 res = Math.min(res, f(i+1, true));
                
//                 // case 2: we want to continue the zeros streak, 
//                 // so we make this into a zero, and continue that
//                 res = Math.min(res, 1 + f(i+1, false));
//             }
//         }
        
//         return memo[i][mustBeOne ? 0 : 1] = res;
//     }
// }

// Recursion: O(N^3 + N) O(N)
// class Solution {
//     char[] a;
//     int n;
//     public int minFlipsMonoIncr(String s) {
//         a = s.toCharArray();
//         n = a.length;
//         return f(0, false);
//     }
    
//     private int f(int i, boolean mustBeOne) {
//         if (i == n) return 0;
        
//         int res = Integer.MAX_VALUE;
        
//         if (mustBeOne) {
//             if (a[i] == '0') {
//                 // it's not matching the rule, so we must flip it
//                 res = Math.min(res, 1 + f(i+1, mustBeOne));
//             }
//             else {
//                 // it should be a 1 and it is a 1 so no problem
//                 res = Math.min(res, f(i+1, mustBeOne));
//             }
//         }
        
//         if (!mustBeOne) {
//             if (a[i] == '0') {
//                 // it can be a zero, so it's just fine
//                 res = Math.min(res, f(i+1, mustBeOne));
//             }
//             else {
//                 // it can be a zero, but it's a one
                
//                 // case 1: it's a normal transition from 0s to 1s
//                 res = Math.min(res, f(i+1, true));
                
//                 // case 2: we want to continue the zeros streak, 
//                 // so we make this into a zero, and continue that
//                 res = Math.min(res, 1 + f(i+1, false));
//             }
//         }
        
//         return res;
//     }
// }