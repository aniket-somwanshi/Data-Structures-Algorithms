class Solution {
    public int longestOnes(int[] a, int k) {
        int start = 0;
        int end = 0;
        int n = a.length;
        int maxi = 0;
        while (end < n) {
            if (a[end] == 1) {
                maxi = Math.max(maxi, end - start + 1);
                end++;
            }
            else if (k > 0){
                k--;
                maxi = Math.max(maxi, end - start + 1);
                end++;
            }
            else {
                while (start < n && a[start] != 0) {
                    start++;
                }
                start++;
                k++;
                end++;
                k--;
            }
        }
        return maxi;
    }
}