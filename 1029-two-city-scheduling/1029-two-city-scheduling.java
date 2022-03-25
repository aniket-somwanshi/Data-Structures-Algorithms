class Solution {
    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        for (int i=0; i<costs.length; i++) {
            costs[i][0] = costs[i][0] - costs[i][1];
        }
        Arrays.sort(costs, (a, b) -> a[0]-b[0]);
        
        int sum = 0;
        // 4/2 = 2 0 1 < 2
        for (int i=0; i<costs.length; i++) {
            if (i<costs.length/2) {
                // go to a
                sum += costs[i][0] + costs[i][1];
            } else {
                // go to b
                sum += costs[i][1];
            }
        }
        return sum;
    }
}