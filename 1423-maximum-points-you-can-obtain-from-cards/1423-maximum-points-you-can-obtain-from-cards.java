class Solution {
    public int maxScore(int[] a, int k) {
        int totalSum = 0;
        for (int num: a) totalSum += num;
        
        int n = a.length;
        int windowSize = n-k;
        
        int currentWindowSum = 0;
        int res = Integer.MIN_VALUE;
        
        int left = 0;
        int right = 0;
        
        for (; right < n; right++) {
            currentWindowSum += a[right];
            
            if (right - left + 1 > windowSize) currentWindowSum -= a[left++];

            if (right - left + 1 == windowSize) {
                // update the res
                res = Math.max(res, totalSum - currentWindowSum);
            }
            
        }        
        return res;
    }
}

// class Solution {
//     int n;
//     Integer[][][] memo;
//     int[] a;
//     int k;
//     public int maxScore(int[] a, int k) {
//         this.a = a;
//         this.k = k;
//         this.n = a.length;
//         this.memo = new Integer[n][n][k+1]; 
//         return f(0, n-1, k);
//     }
    
//     private int f(int i, int j, int k) {
//         if (i > j) return 0;
//         if (k == 0) return 0;
        
//         if (memo[i][j][k] != null) return memo[i][j][k];
        
//         int maxi = Integer.MIN_VALUE;
        
//         maxi = Math.max(maxi, a[i] + f(i+1, j, k-1));
//         maxi = Math.max(maxi, a[j] + f(i, j-1, k-1));
        
//         return memo[i][j][k] = maxi;
//     }
// }