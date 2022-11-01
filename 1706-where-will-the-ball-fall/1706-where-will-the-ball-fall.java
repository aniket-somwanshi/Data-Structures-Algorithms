class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = falling(i, grid);
        }
        
        return result;
    }
    
    private int falling(int pos, int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            int c = pos;
            if (grid[r][c] == 1 && (c >= grid[0].length-1 || grid[r][c+1] == -1)) {
                return -1;
            }
            if (grid[r][c] == -1 && (c <= 0 || grid[r][c-1] == 1)) {
                return -1;
            }
            pos += grid[r][c];
        }
        return pos;
    }
}