class Solution {
    public int numIslands(char[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == '1') {
                    count ++;
                    dfs(a, i, j, rows, cols);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] a, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols) return;
        if (a[i][j] == '0') return;
        a[i][j] = '0';
        dfs(a, i+1, j, rows, cols);
        dfs(a, i, j+1, rows, cols);
        dfs(a, i-1, j, rows, cols);
        dfs(a, i, j-1, rows, cols);
    }

        
        
        
        
        
        
}