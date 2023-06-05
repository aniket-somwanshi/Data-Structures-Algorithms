// O(N*M + M) O(N*M + M)
class Solution {
    Integer[][] memo;
    int n;
    int m;
    int[] a1;
    int[] a2;
    public int maxDotProduct(int[] a1, int[] a2) {
        this.a1 = a1;
        this.a2 = a2;
        n = a1.length;
        m = a2.length;
        memo = new Integer[n][m];
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num: a1) max1 = Math.max(max1, num);
        for (int num: a2) max2 = Math.max(max2, num);
        for (int num: a1) min1 = Math.min(min1, num);
        for (int num: a2) min2 = Math.min(min2, num);
        
        if (max1 * max2 < 0 && min1 * min2 < 0 && max1 * min2 < 0 && max2 * min1 < 0) {
            int res1 = Math.max(max1 * max2, min1 * min2);
            int res2 = Math.max(max1 * min2, min1 * max2);
            return Math.max(res1, res2);
        }
        
        return f(0,0);
    }
    
    private int f(int i, int j) {
        if (i == n || j == m) return 0;
        
        if (memo[i][j] != null) return memo[i][j];
        
        int maxiSum = Integer.MIN_VALUE;
        
        // try to pair i with all next j: 
        for (int k = j; k < m; k++) {
            int candidate = (a1[i] * a2[k]) + f(i+1, k+1);
            maxiSum = Math.max(maxiSum, candidate);
        }
        
        maxiSum = Math.max(maxiSum, (0*0) + f(i+1, j));
        
        return memo[i][j] = maxiSum;
    }
}