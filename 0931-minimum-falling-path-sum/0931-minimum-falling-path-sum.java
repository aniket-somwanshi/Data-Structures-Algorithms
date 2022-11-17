// O()
class Solution {
    public int minFallingPathSum(int[][] a) {
        int rows = a.length, cols = a[0].length;
        
        int[] up = new int[cols];
        // fill first row
        for (int j = 0; j < cols; j++) up[j] = a[0][j];
        
        // fill rest of the tings
        for (int i = 1; i < rows; i++) {
            int[] current = new int[cols];
            for (int j = 0; j < cols; j++) {
                current[j] = Integer.MAX_VALUE;
                if (j - 1 >= 0) current[j] = Math.min(current[j], up[j-1]);
                if (j + 1 < cols) current[j] = Math.min(current[j], up[j+1]);
                current[j] = Math.min(current[j], up[j]);
                current[j] += a[i][j];
            }
            up = current;
        }
        int res = Integer.MAX_VALUE;
        for (int candidate: up) {
            res = Math.min(res, candidate);
        }
        return res;
    }
}