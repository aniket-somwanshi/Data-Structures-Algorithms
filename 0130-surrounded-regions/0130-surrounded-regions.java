class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        List<int[]> safe = new ArrayList<>();
        
        // first row and last row
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') markSafe(0, j, board);
            if (board[rows-1][j] == 'O') markSafe(rows-1, j, board);
        }
        // first col and last col
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') markSafe(i, 0, board);
            if (board[i][cols-1] == 'O') markSafe(i, cols-1, board);
        }
        
        // all that are marked safe, mark them as 0
        // and all the vulnerable 0s make them X
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'P') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
             }
        }
        
    }
    
    private void markSafe(int i, int j, char[][] a) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length) return;
        
        if (a[i][j] == 'X' || a[i][j] == 'P') return;
        
        a[i][j] = 'P';
        
        markSafe(i+1, j, a);
        markSafe(i, j+1, a);
        markSafe(i-1, j, a);
        markSafe(i, j-1, a);
    }
}