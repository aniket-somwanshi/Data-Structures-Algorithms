// O(2*N*M) O(1)
class Solution {
     public void gameOfLife(int[][] board) {
         int rows = board.length;
         int cols = board[0].length;
         
         int[][] dirs = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1},
            {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
         };
         
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < cols; j++) {
                 int oldVal = board[i][j];
                 int count = 0;
                for (int[] dir: dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (isValid(x, y, rows, cols) && decode(board[x][y]) == 1) {
                        count++;
                    } 
                }

                if (board[i][j] == 0) {
                    if (count == 3) board[i][j] = encode(0, 1);
                }
                else {
                    if (count < 2 || count > 3) board[i][j] = encode(1, 0);
                }
             }
         }
         
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < cols; j++) {
                 if (board[i][j] == 2) {
                     board[i][j] = 1;
                 }
                 else if (board[i][j] == -2) {
                     board[i][j] = 0; 
                 }
             }
         }
    }
    
    private boolean isValid(int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c) return false;
        return true;
    }
    
    private int encode(int oldVal, int newVal) {
        if (oldVal == newVal) return oldVal;
        if (newVal < oldVal) return -2;
        if (newVal > oldVal) return 2;
        
        return -9999;
    }
    
    private int decode(int newVal) {
        if (newVal == 0 || newVal == 1) return newVal;
        if (newVal == 2) return 0;
        if (newVal == -2) return 1;
        
        return -9999;
    }
}
// class Solution {
//     public void gameOfLife(int[][] board) {
//         int rows = board.length;
//         int cols = board[0].length;
        
//         int[][] dirs = new int[][] {
//             {1, 0}, {0, 1}, {-1, 0}, {0, -1},
//             {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
//         };
        
//         int[][] a = new int[rows][cols];
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 a[i][j] = board[i][j];        
//             }
//         }
        
        
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 int count = 0;
//                 for (int[] dir: dirs) {
//                     int x = i + dir[0];
//                     int y = j + dir[1];
                    
//                     if (isValid(x, y, rows, cols) && a[x][y] == 1) {
//                         count++;
//                     } 
//                 }
                
//                 if (a[i][j] == 0) {
//                     if (count == 3) board[i][j] = 1;
//                 }
//                 else {
//                     if (count < 2 || count > 3) board[i][j] = 0;
//                 }
//             }
//         }
//     }
    
//     private boolean isValid(int i, int j, int r, int c) {
//         if (i < 0 || j < 0 || i >= r || j >= c) return false;
//         return true;
//     }
// }
