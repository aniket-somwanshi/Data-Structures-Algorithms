class Solution {
    int n;
    int[][] a;
    Long[] memo;
    public long mostPoints(int[][] a) {
        this.n = a.length;
        this.a = a;
        this.memo = new Long[n];
        return f(0);    
    }
    
    private long f(int i) {
        if (i >= n) return 0;
        if (memo[i] != null) return memo[i];
        long c1 = a[i][0] + f(i + a[i][1] + 1);
        long c2 = f(i+1);
        System.out.println(c1 + "`"+c2);
        return memo[i] = Math.max(c1, c2);
    }
}