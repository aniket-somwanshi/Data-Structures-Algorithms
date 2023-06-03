class Solution {
    int n;
    int m;
    int[][] a;
    Integer[][] memo;
    int MOD = 1000000007;
    int[][] dirs = new int[][] {
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    public int countPaths(int[][] a) {
        this.a = a;
        n = a.length;
        m = a[0].length;
        memo = new Integer[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (memo[i][j] == null) {
                    dfs(i, j);
                }
                res = (int)((0L + res + memo[i][j]) % MOD);
            }
        }
        //System.out.println(memo[0][1]);
        return res;
    }
    
    private int dfs(int i, int j) {
        if (memo[i][j] != null) return memo[i][j];
        
        int res = 1;
        for (int[] dir: dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            
            if (isValid(newX, newY) && a[newX][newY] > a[i][j]) {
                res = (int)(0L + res + dfs(newX, newY) % MOD);
            }
        }
        
        return memo[i][j] = res;
    }
    
    private boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m) return false;
        return true;
    }
    
}