class Solution {
    // O(2N) O(1)
    public int[] shortestToChar(String s, char c) {
        char[] a = s.toCharArray();
        int n = a.length;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        
        int index = Integer.MAX_VALUE;
        // backward traversal
        for (int i = n-1; i >= 0; i--) {
            if (a[i] == c) {
                res[i] = 0;
                index = i;
            }
            else {
                res[i] = Math.min(res[i], Math.abs(i-index));
            }
        }
        
        // forward traversal
        index = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] == c) {
                res[i] = 0;
                index = i;
            }
            else {
                res[i] = Math.min(res[i], Math.abs(i-index));
            }
        }
        
        return res;
    }
}