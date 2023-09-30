class Solution {
    int[][] dirs = new int[][] {
        {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        Integer[][] memo = new Integer[rows][cols];
        
        int maxi = 1;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (memo[i][j] == null) {
                    dfs(i, j, matrix, memo);
                }
                maxi = Math.max(maxi, memo[i][j]);
            }
        }
        
        return maxi;
    }
    
    private int dfs(int i, int j, int[][] matrix, Integer[][] memo) {
        if (memo[i][j] != null) return memo[i][j];
        
        int maxiLength = 0;
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (!isValid(x, y, matrix.length, matrix[0].length)) continue;
            
            if (matrix[x][y] > matrix[i][j]) {
                maxiLength = Math.max(maxiLength, dfs(x, y, matrix, memo));
            }

         }
        
        return memo[i][j] = maxiLength + 1;
    }
    
    private boolean isValid(int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c) return false;
        return true;
    }
}











