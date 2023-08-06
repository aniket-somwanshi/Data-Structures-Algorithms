class Solution {
    public void setZeroes(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        
        boolean isFirstRowMarked = false;
        boolean isFirstColMarked = false;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] != 0) continue;
                
                // if this the first row or column
                if (i == 0) isFirstRowMarked = true;
                if (j == 0) isFirstColMarked = true;
                
                // mark the row & col as marked
                a[i][0] = 0;
                a[0][j] = 0;
            }
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (a[i][0] == 0 || a[0][j] == 0) a[i][j] = 0;
            }
        }
        
        if (isFirstRowMarked) {
            for (int j = 0; j < cols; j++) {
                a[0][j] = 0;
            }
        }
        
        if (isFirstColMarked) {
            for (int i = 0; i < rows; i++) {
                a[i][0] = 0;
            }
        }
        
        
    }
}