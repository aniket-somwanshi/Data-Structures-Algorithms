class Solution {
    int[] a;
    int n;
    int d;
    Integer[] memo;
    public int maxJumps(int[] arr, int d) {
        a = arr;
        n = a.length;
        this.d=d;
        memo = new Integer[n];
        int res = 0;
        for (int start = 0; start < n; start++) {
            res = Math.max(res, 1 + f(start));
        }
        return res;
    }
    
    private int f(int ind) {
        if (memo[ind] != null) return memo[ind];
        int maxi = 0;
        
        // go forward 'd' steps
        for (int i = ind + 1; i < n && i <= ind + d; i++) {
            if (a[i] >= a[ind]) break; // can't go past this barrier
            maxi = Math.max(maxi, 1 + f(i));
        }
        
        // go backwards 'd' steps
        for (int i = ind - 1; i >= 0 && i >= ind - d; i--) {
            if (a[i] >= a[ind]) break; // can't go past this barrier
            maxi = Math.max(maxi, 1 + f(i));
        }
        
        return memo[ind] = maxi;
    }
}