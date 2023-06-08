// O(N*M) O(N*M + N) -memo
class Solution {
    int n;
    int k;
    int[] a;
    int m;
    Integer[][] memo;
    public int minDays(int[] a, int m, int k) {
        this.a = a;
        this.n = a.length;
        this.k = k;
        this.m = m;
        
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        
        for (int num: a) mini = Math.min(mini, num);
        for (int num: a) maxi = Math.max(maxi, num);

        // base case of impossible
        if (n < m * k) return -1;
        
        int left = mini;
        int right = maxi;
        
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (isPossible(mid)) {
                res = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return res == Integer.MAX_VALUE?-1:res;
    }
    
    private boolean isPossible(int d) {
        int f = 0;
        int b = 0;
        for (int num: a) {
            if (num <= d) {
                f++;
            }
            else {
                f = 0;
            }
            
            
            if (f == k) {
                b++;
                f = 0;
            }
            if (b==m) break;
        }
        return b==m;
    }
    
}


// // O(N*M) O(N*M + N) -memo
// class Solution {
//     int n;
//     int k;
//     int[] a;
//     Integer[][] memo;
//     public int minDays(int[] a, int m, int k) {
//         this.a = a;
//         this.n = a.length;
//         this.k = k;
        
//         memo = new Integer[n][m+1];
//         int ans = f(0, m);
//         return (ans == Integer.MAX_VALUE) ? -1 : ans;
//     }
    
//     private int f(int index, int m) {
//         // base
//         if (index >= n) return m == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//         if (m == 0) return Integer.MIN_VALUE;
        
//         if (memo[index][m] != null) return memo[index][m];
            
//         if (index + k - 1 >= n) return Integer.MAX_VALUE;
        
//         // take this
//         int maxi = Integer.MIN_VALUE;
//         for (int i = index; i < index + k; i++) {
//             maxi = Math.max(maxi, a[i]);
//         }
//         int c1 = Math.max(maxi, f(index + k, m-1));
        
//         // not take this
//         int c2 = f(index + 1, m);
        
//         return memo[index][m] = Math.min(c1, c2);
//     }
// }