// O(E logV) O(V)  -- E = V = N*M 
class Solution {
    int rows;
    int cols;
    
    int[][] dirs = new int[][] {
        {1, 0}, {0, 1,}, {-1, 0}, {0, -1}
    }; 
    public int minimumEffortPath(int[][] a) {
        rows = a.length;
        cols = a[0].length;
        
        int[][] distance = new int[rows][cols]; 
        for (int[] d: distance) Arrays.fill(d, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, b1) -> a1[0] - b1[0]);
        
        distance[0][0] = 0;
        pq.add(new int[] {0, 0, 0});
        
        while (!pq.isEmpty()) {
            int currentEffort = pq.peek()[0];
            int i = pq.peek()[1];
            int j = pq.peek()[2];
            pq.poll();
            
            // answer for destination can't be further modified after this so return it
            if (i == rows-1 && j == cols-1) return currentEffort;
            
            for (int[] dir: dirs) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x < 0 || y < 0 || x >= rows || y >= cols) continue;
                
                if (Math.max(currentEffort, Math.abs(a[i][j] - a[x][y])) < distance[x][y]) {
                    distance[x][y] = Math.max(currentEffort, Math.abs(a[i][j] - a[x][y]));
                    pq.add(new int[] {distance[x][y], x, y});
                }
            }   
        }
        return -1; 
            
    }
        
}