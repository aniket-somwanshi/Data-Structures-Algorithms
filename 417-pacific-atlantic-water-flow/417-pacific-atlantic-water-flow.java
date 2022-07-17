class Solution {
    private int[][] heights;
    private int m;
    private int n;
    
    private static final int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        // prepare starting cells for pacific oceans
        final Queue<int[]> pacificQ = getPacificOceanQueue();
        // prepare starting cells for atlantic oceans
        final Queue<int[]> atlanticQ = getAtlanticOceanQueue();
        // tranverse from pacfic ocean cells and do bfs to record from those cells, where  water can reach
        final boolean[][] pacificVisited = bfs(pacificQ);
        // tranverse from atlantic ocean cells and do bfs to record from those cells, where water can reach
        final boolean[][] atlanticVisited = bfs(atlanticQ);
        final List<List<Integer>> result = new ArrayList<>();
        // interated over both the visited maps and record indexes which are true for both
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacificVisited[i][j] && atlanticVisited[i][j]) {
                    final List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    result.add(curr);
                }
            }
        }
        return result;
    }
    
    private Queue<int[]> getPacificOceanQueue() {
        final Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        for(int i = 1; i < m; i++) {
            q.offer(new int[]{i, 0});
        }
        for(int j = 1; j < n; j++) {
            q.offer(new int[]{0, j});
        }
        return q; 
    }
    
     private Queue<int[]> getAtlanticOceanQueue() {
        final Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{m- 1, n - 1});
        for(int i = 0; i < m -1 ; i++) {
            q.offer(new int[]{i, n - 1});
        }
        for(int j = 0; j < n -1; j++) {
            q.offer(new int[]{m - 1, j});
        }
        return q; 
    }
    
    private boolean[][] bfs(final Queue<int[]> q) {
        final boolean[][] visited = new boolean[m][n];
        while(!q.isEmpty()) {
            // remove mark* work add*
            final int[] curr = q.poll();
            if(visited[curr[0]][curr[1]]) {
                continue;
            }
            visited[curr[0]][curr[1]] = true;
            final int currHeight = this.heights[curr[0]][curr[1]];
            for(final int[] dir : dirs) {
                final int newX = dir[0] + curr[0];
                final int newY = dir[1] + curr[1];
                if(newX < 0 || newY < 0 || newX >= m || newY >= n 
                   || visited[newX][newY]
                   || heights[newX][newY] < currHeight
                  ){
                    continue;   
                }
                q.offer(new int[]{newX, newY});
            }
            
        }
        return visited;
    }
    // wrong solution
    // as water can flow in all 4 directions, and NOT just back and up or down or forward 
//     public List<List<Integer>> pacificAtlantic(int[][] height) {
//         int rows = height.length;
//         int cols = height[0].length; 
//         List<List<Integer>> res = new LinkedList<>();
        
//         // array to mark if an island can be reach the occean
//         boolean[][] visit = new boolean[rows][cols]; 
//         boolean[][] visit1 = new boolean[rows][cols]; 
//         // intialize to false
//         for (int i = 0; i < rows; i++) 
//             for (int j = 0; j < cols; j++) 
//                 visit[i][j] = visit1[i][j] = false;
        
//         // mark pacific (top-left) occean reachable islands
       
        
//         // all the leftmost and all the topmost islands are touching 
//         // so they are reachable
//         for (int i = 0; i < cols; i++) visit[0][i] = true;
//         for (int i = 0; i < rows; i++) visit[i][0] = true;
//         // mark rest
//         for (int i = 1; i < rows; i++) {
//             for (int j = 1; j < cols; j++) {
//                 if ((height[i][j] >= height[i-1][j] && visit[i-1][j]) || 
//                 (height[i][j] >= height[i][j-1] && visit[i][j-1])) visit[i][j] = true;
//             }
//         }
        
//         // mark atlantic (bottom-right) occean reachable islands
//         for (int i = 0; i < cols; i++) {
//             visit1[rows-1][i] = true;
//         }
//         for (int i = 0; i < rows; i++) {
//             visit1[i][cols-1] = true;
//         }
        
        
//         for (int i = rows-2; i >= 0; i--) {
//             for (int j = cols-2; j >= 0; j--) {
//                 if ((height[i][j] >= height[i+1][j] && visit1[i+1][j]) ||
//                    (height[i][j] >= height[i][j+1] && visit1[i][j+1])) {
//                     visit1[i][j] = true;
//                 }
//             }
//         }
        
        
//         // if an island is reachable to both occeans, add to res
//          for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (visit[i][j] && visit1[i][j]) res.add(new ArrayList<>(Arrays.asList(i, j)));
//             }
//         }
        
//         // return res
//         return res;
//     }
}