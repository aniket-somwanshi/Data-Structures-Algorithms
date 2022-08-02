class Solution {
    /*
    O(logN^2*N*logN)
    */
    public int kthSmallest(int[][] a, int k) {
        int n = a.length;
        int low = a[0][0];
        int high = a[n-1][n-1];
        k = k - 1; // for 8th smallest element, we need to have 7 elements <= to it
        while (low <= high) {
            int mid = low + (high - low)/2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += getNumbersLessThan(a[i], n, mid);
            }
            
            if (count <= k) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return low;
    }
    
    private int getNumbersLessThan(int[] a, int n, int target) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (a[mid] <= target) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return low;
    }
}