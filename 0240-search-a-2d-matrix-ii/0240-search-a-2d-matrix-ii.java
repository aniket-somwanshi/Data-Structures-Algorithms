class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int i = 0;
        int j = cols-1;
        
        while (i < rows && j >= 0) {
            if (target < matrix[i][j]) {
                j--;
            }
            else if (target > matrix[i][j]) {
                i++;
            }
            else return true;
        }
        return false;
    }
}