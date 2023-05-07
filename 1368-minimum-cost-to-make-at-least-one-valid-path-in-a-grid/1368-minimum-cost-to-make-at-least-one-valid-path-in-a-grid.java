class Solution {
    int r;
    int c;
    public int minCost(int[][] a) {
        r = a.length;
        c = a[0].length;
        
        boolean visited[][][] = new boolean[r+1][c+1][(r*c)+1];
        Deque<int[]> q = new LinkedList<>(); // i,j, cost
        q.add(new int[] {0, 0, 0});
        visited[0][0][0] = true;
        int miniCost = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int cost = current[2];
            // update miniCost if reached end
                if (x == r-1 && y == c-1) {
                   return
                       miniCost = Math.min(miniCost, cost);
                }
        
            for (int val = 1; val <= 4; val++) {
                int newX = x + f(val)[0];
                int newY = y + f(val)[1];
                // System.out.println(newX+"--"+newY);
                
                
                
                if (val == a[x][y]) {    
                    if (isInBounds(newX, newY) && !visited[newX][newY][cost]) {
                        visited[newX][newY][cost] = true;
                        q.addFirst(new int[] {newX, newY, cost});
                    }
                }
                else {
                    if (cost+1 >= r*c) continue;
                    //System.out.println(newX+"--"+newY);
                   // System.out.println(cost+1);
                    if (isInBounds(newX, newY) && !visited[newX][newY][cost+1]) {
                        visited[newX][newY][cost+1] = true;
                        q.addLast(new int[] {newX, newY, cost+1});
                    }
                }
            }    
        }
        
        return miniCost;
    }
    
    private boolean isInBounds(int x, int y) {
        if (x < 0 || y < 0 || x >= r || y >= c) return false;
        return true;
    }
    
    private int[] f(int val) {
        switch (val) {
            case 1: return new int[] {0, 1}; 
            case 2: return new int[] {0, -1};
            case 3: return new int[] {1, 0}; 
            case 4: return new int[] {-1, 0}; 
        }
        return new int[] {};
    }
}