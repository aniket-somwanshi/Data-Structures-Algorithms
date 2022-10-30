class Solution {
    // O(NlogN + N) O(N)
    public int eraseOverlapIntervals(int[][] a) {
        Arrays.sort(a, (a1, a2) -> a1[0] - a2[0]);
        int n = a.length;
        
        int[] current = a[0];
        int c = 0;
        
        for (int i = 1; i < n; i++) {
            if (current[0] <= a[i][0] && a[i][0] < current[1]) {
                c++;
                current = a[i][1] < current[1] ? a[i] : current;
            }
            else {
                current = a[i];
            }
            
            
        }
        return c;
    }
}