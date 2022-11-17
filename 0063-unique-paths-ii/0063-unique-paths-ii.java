class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int rows = a.length, cols = a[0].length;
        
        int[] up = new int[cols];
        up[0] = a[0][0] == 1 ? 0 : 1;
        for (int j = 1; j < cols; j++) up[j] = a[0][j] == 1 ? 0 : up[j-1];
        
        for (int i = 1; i < rows; i++) {
            int[] current = new int[cols];
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == 1) current[j] = 0;
                else if (j == 0) current[j] = up[j];
                else current[j] = current[j-1] + up[j];
            }
            up = current;
        }
        return up[cols-1];
    }
}