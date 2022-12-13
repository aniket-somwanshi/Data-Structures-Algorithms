class Solution {
    public int candy(int[] a) {
        int n = a.length;
        int[] cost = new int[n];
        int costSum = 0;
        
        Arrays.fill(cost, 1);
        
        for (int i = 1; i < n; i++) {
            // if prev is smaller, my cost should be greater than it
            if (a[i-1] < a[i] && cost[i-1] >= cost[i]) {
                cost[i] = cost[i-1] + 1;
            }
        }
        for (int i = n-2; i >= 0; i--) {
            if (a[i+1] < a[i] && cost[i+1] >= cost[i]) {
                cost[i] = cost[i+1] + 1;
            }
        }
        
        for (int i = 0; i < n; i++) costSum += cost[i];
        
        return costSum;
    }
}