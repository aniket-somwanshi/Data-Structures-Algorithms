class Solution {
 /** O(2*M*N) O(1) 
 * Space Optimized Dynamic Programming
 *
 * The first iteration is from top left corner to bottom right. In this
 * iteration we are checking Top and Left neighbors as they have been already
 * solved.
 *
 * The second iteration is from bottom right corner to top left corner. In this
 * iteration we are checking Bottom and Right neighbors and also compare them
 * with the result of the current cell from the previous iteration.
 *
 * 
 *
 * M = Number of rows. N = Number of columns.
 */
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int MAX_VALUE = 100000;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 0) {
                    int left = j-1 >= 0 ? mat[i][j-1] : MAX_VALUE;
                    int top = i-1 >= 0 ? mat[i-1][j] : MAX_VALUE;
                    
                    mat[i][j] = Math.min(left, top) + 1;
                }
            }
        }
        
        for (int i = rows-1; i >= 0; i--) {
            for (int j = cols -1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int right = j+1 < cols ? mat[i][j+1] : MAX_VALUE;
                    int bottom = i+1 < rows ? mat[i+1][j] : MAX_VALUE;
                    
                    mat[i][j] = Math.min(mat[i][j], Math.min(right, bottom) + 1);
                }
            }
        }
        
        return mat;
    }
}