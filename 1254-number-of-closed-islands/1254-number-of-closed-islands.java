class Solution {
 public int closedIsland(int[][] grid) {
        int numberClosed = 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 1; i < grid.length - 1; i++) {
            for(int j = 1; j < grid[i].length - 1; j++) {
                if(!visited[i][j] && grid[i][j] == 0) {
                    if(enclosed(visited, grid, i, j)) {
                        numberClosed++;
                    }
                }
            }
        }
        
        
        return numberClosed;
    }
    
    boolean enclosed(boolean[][] visited, int[][] grid, int r, int c) {
        // 0 on border
        if((r == 0 || c == 0 || r == grid.length-1 || c == grid[r].length-1) && grid[r][c] == 0) return false;
        
        // hit 1 or already visited
        if(grid[r][c] == 1 || visited[r][c]) return true;
        
        // update visited
        visited[r][c] = true;
        
        // continue DFS search (MUST DO LIKE THIS TO VISIT ALL ADJACENT 0'S)
        boolean down = enclosed(visited, grid, r+1, c);
        boolean right = enclosed(visited, grid, r, c+1);
        boolean up = enclosed(visited, grid, r-1, c);
        boolean left = enclosed(visited, grid, r, c-1);
        
        return down && right && up && left;
    }

}