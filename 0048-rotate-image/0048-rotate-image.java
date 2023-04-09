class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows;
        // transpose
        int pivot = 0;
        
        while (pivot < rows) {
            int i = pivot + 1;
            while (i < rows) {
                swap(matrix, pivot, i, i, pivot);
                i++;
            }
            pivot++;
        }
        
        // reverse all rows
        for (int row = 0; row < rows; row++) {
            int i = 0;
            int j = rows-1;
            while (i < j) {
                swap(matrix, row, i, row, j);
                i++;
                j--;
            }
        }
    }
    
    private void swap(int[][] matrix, int i, int j, int x, int y) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}