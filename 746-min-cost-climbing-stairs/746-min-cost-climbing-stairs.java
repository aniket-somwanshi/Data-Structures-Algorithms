class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        
        // we hyave [cost.length + 1] because we treat top floor as reachable stair
        int minCost[] = new int[cost.length + 1];
        
        // we can directly start from step 2 because we minimum cost to step 0 or 1 are both 0
        for(int i = 2; i < minCost.length; i++)
        {
            int takeOneStep = minCost[i-1] + cost[i-1];
            int takeTwoStep = minCost[i-2] + cost[i-2];
            minCost[i] = Math.min(takeOneStep, takeTwoStep);
        }
        return minCost[minCost.length - 1];
    }
}