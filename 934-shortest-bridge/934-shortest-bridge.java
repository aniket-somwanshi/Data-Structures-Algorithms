class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    /*
    Start bfs from all positions in first island, return bfs level when we reach second island
    */
    
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        for (boolean[] vis: visited) Arrays.fill(vis, false);
        
        Queue<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    populateFirstIsland(i, j, grid, q, visited);
                    break;
                }
            }
            if (q.isEmpty() == false) break;
        }
        
        int level = 0;
        while (q.isEmpty() == false) {
            int size = q.size();
            while (size-- > 0) {
                Pair current = q.poll();
                for (int[] dir: directions) {
                    int newX = current.i + dir[0];
                    int newY = current.j + dir[1];
                    if (isValid(newX, newY, grid, visited)) {
                        if (grid[newX][newY] == 1) return level;
                        q.add(new Pair(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            level++;
        }
        return 1;
    }
    
    private boolean isValid(int i, int j, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n) return false;
        if (visited[i][j]) return false;
        return true;
    }
    
    private void populateFirstIsland(int i, int j, int[][] grid, Queue<Pair> q, boolean[][] visited) {
        visited[i][j] = true;
        q.add(new Pair(i,j));
        for (int[] dir: directions) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (isSameIsland(newX, newY, grid, visited)) populateFirstIsland(newX, newY, grid, q, visited);
        }
    }
    
    private boolean isSameIsland(int i, int j, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n) return false;
        if (visited[i][j]) return false;
        if (grid[i][j] == 0) return false;
        return true;
    } 
}