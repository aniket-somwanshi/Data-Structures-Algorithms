// O(N*M) O(N*M) -- memo
class Solution {
    Integer[][] memo;
    int[][] a;
    int[][] mc;
    int rows;
    int cols;
    public int minPathCost(int[][] a, int[][] mc) {
        rows = a.length;
        cols = a[0].length;
        
        this.a = a;
        this.mc = mc;
        
        // memo[i][j] is minimum cost of path
        // starting from [i][j] and 
        // ending at the last row
        memo = new Integer[rows][cols];
        
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            mini = Math.min(mini, miniCost(0, j));
        }
        
        return mini;
    }
    
    private int miniCost(int i, int j) {
        // base case
        if (i == rows - 1) return a[i][j];
        
        if (memo[i][j] != null) return memo[i][j];
        
        int cost = Integer.MAX_VALUE;
        
        for (int nextJ = 0; nextJ < cols; nextJ++) {
            int currentValue = a[i][j];
            int movingCost = mc[currentValue][nextJ];
            int currentCost = movingCost +  
                miniCost(i+1, nextJ);
            cost = Math.min(cost, currentCost);
        }
        
        cost += a[i][j];
        
        return memo[i][j] = cost;
    }
}