// O(N*M) O(M+N -- dp
class Solution {
    public int minPathSum(int[][] a) {
        int rows = a.length, cols = a[0].length;
        int[] up = new int[cols];
        up[0] = a[0][0];
        for (int j = 1; j < cols; j++) {
            up[j] = up[j-1] + a[0][j];
        }
        
        for (int i = 1; i < rows; i++) {
            int[] current = new int[cols];
            for (int j = 0; j < cols; j++) {
                if (j == 0) current[j] = up[j] + a[i][j];
                else current[j] = a[i][j] + Math.min(current[j-1], up[j]);
            }
            up = current;
        }
        return up[cols-1];
    }
}