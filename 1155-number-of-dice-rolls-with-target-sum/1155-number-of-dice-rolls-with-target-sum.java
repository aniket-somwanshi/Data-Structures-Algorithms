// O(target*N * K) O(target*N) -- memo
class Solution {
    private int MOD = 1000000007;
    private int k;
    
    private Integer[][] memo;
    public int numRollsToTarget(int n, int k, int target) {
        this.k = k;
        this.memo = new Integer[target+1][n+1];
        return f(target, n);
    }
    
    private int f(int t, int n) {
        if (n == 0) {
           return t == 0 ? 1 : 0;
        }  
        if (t < 0) return 0;
        
        if (memo[t][n] != null) return memo[t][n];
        
        int totalPossibleWays = 0;
        // select any number on the dice upto k
        for (int dice = 1; dice <= k; dice++) {
            totalPossibleWays = ((f(t - dice, n-1) % MOD) + totalPossibleWays) % MOD;
        }
             
        return memo[t][n] = totalPossibleWays;
    }
}

// // O(K^N) O(N) -- brute
// class Solution {
//     private int MOD = 1000000007;
//     private int k;
    
//     public int numRollsToTarget(int n, int k, int target) {
//         this.k = k;
//         return f(target, n);
//     }
    
//     private int f(int t, int n) {
//         if (n == 0) {
//            return t == 0 ? 1 : 0;
//         }  
        
//         int totalPossibleWays = 0;
//         // select any number on the dice upto k
//         for (int dice = 1; dice <= k; dice++) {
//             totalPossibleWays = ((f(t - dice, n-1) % MOD) + totalPossibleWays) % MOD;
//         }
        
//         return totalPossibleWays;
//     }
// }