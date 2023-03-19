// O(N*3) O(N*3 + N)
class Solution {
    Integer[][] memo;
    public int maxSumDivThree(int[] a) {
        memo = new Integer[a.length][3];
        return f(0, 0, a);
    }
    
    private int f(int i, int currentSumMod, int[] a) {
        if (i == a.length) {
            return currentSumMod == 0 ? 0 : Integer.MIN_VALUE;
        }
        
        if (memo[i][currentSumMod] != null) return memo[i][currentSumMod];
        
        // choose
        int res1 = f(i+1, (currentSumMod+a[i])%3, a);
        res1 = res1 == Integer.MIN_VALUE ? res1 : res1 + a[i];
        
        // not choose
        int res2 = 0 + f(i+1, currentSumMod, a);
        
        return memo[i][currentSumMod] = Math.max(res1, res2);
    }
}

// // O(2^N) O(N)
// class Solution {
//     public int maxSumDivThree(int[] a) {
//         return f(0, 0, a);
//     }
    
//     private int f(int i, int currentSumMod, int[] a) {
//         if (i == a.length) {
//             return currentSumMod == 0 ? 0 : Integer.MIN_VALUE;
//         }
        
//         // choose
//         int res1 = f(i+1, (currentSumMod+a[i])%3, a);
//         res1 = res1 == Integer.MIN_VALUE ? res1 : res1 + a[i];
        
//         // not choose
//         int res2 = 0 + f(i+1, currentSumMod, a);
        
//         return Math.max(res1, res2);
//     }
// }