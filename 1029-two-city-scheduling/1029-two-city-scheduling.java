class Solution {
    private Integer[][] dp;
    private int[][] costs;
    private int n;
    public int twoCitySchedCost(int[][] costs) {
        this.costs = costs;
        this.n = costs.length;
        this.dp = new Integer[n][n];
        return dfs(0, 0, 0, 0);
    }
    
    private int dfs(int index, int peopleA, int peopleB, int cost) {
        if (index >= n) return 0;
        
        if (dp[peopleA][peopleB] != null) {
            return dp[peopleA][peopleB];
        }
        
        if (peopleA < n/2 && peopleB < n/2) 
            dp[peopleA][peopleB] =  Math.min(costs[index][0] + dfs(index+1, peopleA + 1, peopleB, cost + costs[index][0]), 
                       costs[index][1] + dfs(index+1, peopleA, peopleB + 1, cost + costs[index][1]));
        
        else if (peopleA < n/2 && peopleB == n/2)
            dp[peopleA][peopleB] = costs[index][0] + dfs(index+1, peopleA + 1, peopleB, cost + costs[index][0]);
        
        else 
            dp[peopleA][peopleB] = costs[index][1] + dfs(index+1, peopleA, peopleB + 1, cost + costs[index][1]);
        
        return dp[peopleA][peopleB];
    }
}