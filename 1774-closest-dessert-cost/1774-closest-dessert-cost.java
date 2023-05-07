class Solution {
    int[] a;
    int[] b;
    int n;
    int m;
    int miniDiff;
    int miniCost;
    int target;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.n = baseCosts.length;
        this.m = toppingCosts.length;
        this.target = target;
        this.a = baseCosts;
        this.b = toppingCosts;
        
        this.miniCost = Integer.MAX_VALUE;
        this.miniDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            f(0, a[i]);
        }
        
        return miniCost;
    }
    
    private void f(int i, int currentCost) {
        if (i == m) {
            if (Math.abs(currentCost - target) == miniDiff) {
                miniCost = Math.min(miniCost, currentCost);
            }
            if (Math.abs(currentCost - target) < miniDiff) {
                miniCost = currentCost;
                miniDiff = Math.abs(currentCost - target);
            }
            return;
         }
        
        f(i+1, currentCost + 0);
        
        f(i+1, currentCost + b[i]);
        
        f(i+1, currentCost + b[i]*2);
    }
    
    
}

// WRONG APPROACH: THIS PROBLEM CAN't BE A DP COS
// SUBPROBLEMS ANSWER CANT" BE AGGREGATED TO FORM MAIN PROBLEM ASNWERS
// class Solution {
//     int[] a;
//     int[] b;
//     int n;
//     int m;
//     int currentTarget;
//     public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
//         this.n = baseCosts.length;
//         this.m = toppingCosts.length;
        
//         this.a = baseCosts;
//         this.b = toppingCosts;
        
//         int miniCost = Integer.MAX_VALUE;
//         for (int i = 0; i < n; i++) {
//             currentTarget = target - a[i];
//             miniCost = Math.min(miniCost, f(0));
//         }
        
//         return miniCost;
//     }
    
//     private int f(int i) {
//         if (i == m) return 0;
        
//         int c1 = 0 + f(i+1);
        
//         int c2 = b[i] + f(i+1);
        
//         int c3 = b[i]*2 + f(i+1);
        
//         int res = Integer.MAX_VALUE;
//         if (Math.abs(currentTarget - c1) <= Math.abs(currentTarget - c2) && Math.abs(currentTarget - c1) <= Math.abs(currentTarget - c3)) {
//             res = c1;
//         }
        
//         if (Math.abs(currentTarget - c2) <= Math.abs(currentTarget - c1) && Math.abs(currentTarget - c2) <= Math.abs(currentTarget - c3)) {
//             res = c2;
//         }
        
//         if (Math.abs(currentTarget - c3) <= Math.abs(currentTarget - c1) && Math.abs(currentTarget - c3) <= Math.abs(currentTarget - c2)) {
//             res = c3;
//         }
        
        
//         return res;
//     }
    
    
// }