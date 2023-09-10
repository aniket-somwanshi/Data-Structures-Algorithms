class Solution {
    int[][] dirs = new int[][] {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    }; 
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    markAsVisited(i, j, grid);
                }
            }
        }
        return count;
    }
    
    private void markAsVisited(int i, int j, char[][] grid) {
        // BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int[] dir: dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    q.add(new int[] {x, y});
                }
            }
        }
    }

}