// O(2(N*M)) O(4) --bfs 
class Pair {
    int x; int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int rows;
    int cols;
    public int numEnclaves(int[][] a) {
        this.rows = a.length;
        this.cols = a[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < rows; i++) {
            if (a[i][0] == 1) {
                a[i][0] = 2;
                q.add(new Pair(i, 0));
            }
            if (a[i][cols-1] == 1) {
                a[i][cols-1] = 2;
                q.add(new Pair(i, cols-1));
            }
        }
        for (int j = 0; j < cols; j++) {
            if (a[0][j] == 1) {
                a[0][j] = 2;
                q.add(new Pair(0, j));
            }
            if (a[rows-1][j] == 1) {
                a[rows-1][j] = 2;
                q.add(new Pair(rows-1, j));
            }
        }
        
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int x = current.x;
            int y = current.y;
            
            for (int[] dir: dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX < 0 || newY < 0 || newX >= rows || newY >= cols) continue;
                
                if (a[newX][newY] == 1) {
                    a[newX][newY] = 2;
                    q.add(new Pair(newX, newY));
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == 1) count++;
            }
        }
        return count;
    }
}