class Solution {
    // O(N*N) O(1)
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        if (n == 1) {
            int res = Integer.MAX_VALUE;
            for (int num: matrix[0]) {
                res = Math.min(res, num);
            }
            return res;
        }
        
        for (int i = n-2; i >= 1; i--) {
            for (int j = n-1; j >= 0; j--) {
                int minFromChildBelow = matrix[i+1][j];
                if (j-1 >= 0) minFromChildBelow = Math.min(minFromChildBelow, matrix[i+1][j-1]);
                if (j+1 < n) minFromChildBelow = Math.min(minFromChildBelow, matrix[i+1][j+1]);
                matrix[i][j] += minFromChildBelow;
            }
        }
        
        
        
        int miniSum = Integer.MAX_VALUE;
        for (int j = n-1; j >= 0; j--) {
            int minFromChildBelow = matrix[1][j];
            if (j-1 >= 0) minFromChildBelow = Math.min(minFromChildBelow, matrix[1][j-1]);
            if (j+1 < n) minFromChildBelow = Math.min(minFromChildBelow, matrix[1][j+1]);
            miniSum = Math.min(miniSum, minFromChildBelow + matrix[0][j]);
        }
        return miniSum;
    }
}