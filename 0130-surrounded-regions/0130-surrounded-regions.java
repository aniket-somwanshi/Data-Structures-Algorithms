class Solution {
    int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        // travserse borders
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                populateProtectedCells(i, 0, board);    
            }
            if (board[i][cols-1] == 'O') {
                populateProtectedCells(i, cols-1, board);    
            } 
        }
        
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                populateProtectedCells(0, j, board);    
            }
            if (board[rows-1][j] == 'O') {
                populateProtectedCells(rows-1, j, board);    
            } 
        } 
        
        for (int i = 0; i < rows; i++) {
             for (int j = 0; j < cols; j++) {
                 if (board[i][j] == 'P') board[i][j] = 'O';
                 else if (board[i][j] == 'O') board[i][j] = 'X';
             } 
        }
    }
    
    private void populateProtectedCells(int i, int j, char[][] board) {
        board[i][j] = 'P';
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
            if (board[x][y] == 'O') {
                 populateProtectedCells(x, y, board); 
            }
        }
    }
}