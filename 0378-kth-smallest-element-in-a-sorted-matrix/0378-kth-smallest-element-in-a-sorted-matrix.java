class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (numbersLessThan(mid, matrix) >= k) {
                res = mid;
                right = mid-1;
            }
            else {
                left = mid + 1;
            }
        }
        return res;
    }
    
    private int numbersLessThan(int num, int[][] matrix) {
        
        int count = 0;
        int n = matrix.length;
        int i = 0;
        int j = n-1;
        while (i<n  && j >= 0) {
            while (j >= 0 && matrix[i][j] > num) {
                j--;
            }
            count += j+1;
            i++;
        }
        return count;
    }
}