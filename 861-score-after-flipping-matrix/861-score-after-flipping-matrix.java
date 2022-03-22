class Solution {
    /*
    O(4(N*M))
    1. check if a row should be flipped 
    2. flip those rows
    3. check if a col can be flipped 
    4. flip those cols
    5. sum up binary numbers of all rows
    6. return sum
    */
    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (canRowBeFlipped(grid[i]) == true) {
                flipRow(grid[i]);
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (canColumnBeFlipped(grid, j) == true) {
                flipColumn(grid, j);
            }
        }
        
        return getSum(grid);
    }
    
    
    
    private boolean canRowBeFlipped(int[] row) {
        boolean zeroFound = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1 && zeroFound == true) {
                return true;
            }
            else if (row[i] == 1 && zeroFound == false) return false;
            else if (row[i] == 0) zeroFound = true;

        }
        return zeroFound;
    }
    
    private boolean canColumnBeFlipped(int[][] grid, int j) {
        int noOfElementsInCol = grid.length;
        int noOfOnes = 0;
        for (int i = 0; i < grid.length; i++) {
            noOfOnes += grid[i][j];
        }
        return noOfOnes < (noOfElementsInCol - noOfOnes) ? true : false;
    }
    
    private void flipRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = row[i]*(-1) + 1;
        }
    }
    
    private void flipColumn(int[][] grid, int j) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][j] = grid[i][j] * (-1) + 1;
        }
    }

    
    private int getSum(int[][] grid) {
        int powerOfTwo = 0;
        int cols = grid[0].length;
        int rows = grid.length;
        
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            powerOfTwo = 0;
            for (int j = cols-1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    sum += Math.pow(2, powerOfTwo);
                    
                }
                powerOfTwo++;
            }
        }
        
        return sum;
    }
}