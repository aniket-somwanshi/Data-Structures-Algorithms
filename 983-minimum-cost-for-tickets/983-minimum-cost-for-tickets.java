class Solution {
    private Integer[] minCost; // min cost from index i to end
    private int[] days;
    private int[] costs;
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        this.minCost = new Integer[days.length];
        return dfs(0);
    }
    
    private int dfs(int index) {
        if (index >= days.length) return 0;
        
        if (minCost[index] != null) return minCost[index];
        
        int cost1 = dfs(getLastIndexCovered(index, 1) + 1) + costs[0];  // 1 day pass taken 
        int cost2 = dfs(getLastIndexCovered(index, 7) + 1) + costs[1];  // 7 day pass taken 
        int cost3 = dfs(getLastIndexCovered(index, 30)+ 1) + costs[2];  // 30 day pass taken 
        
        minCost[index] = Math.min(cost1, Math.min(cost2, cost3));
        return minCost[index];
    }
    
    private int getLastIndexCovered(int index, int daysAllowed) {
        int left = index;
        int right = days.length-1;
        int lastIndexCovered = 0;
        int lastDayAllowed = days[index] + daysAllowed - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (days[mid] <= lastDayAllowed) {
                lastIndexCovered = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return lastIndexCovered;
    }
}