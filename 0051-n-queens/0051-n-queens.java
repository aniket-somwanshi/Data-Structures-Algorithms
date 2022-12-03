// try to place a Queen at all places 
// if possible, place it and move on
// if not possible try next cell
// if nth queen placed, add to answer
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        recur(0, board, n, res);
        return res;
    }
    
    private void recur(int row, char[][] board, int n, List<List<String>> res) {
        if (row == n) {
            res.add(convertToRes(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isPossible(row, col, board, n)) {
                // take
                board[row][col] = 'Q';
                recur(row + 1, board, n, res);
                
                // not take
                board[row][col] = '.';
            }
        }   
    }
    
    private List<String> convertToRes(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] b: board) {
            res.add(String.valueOf(b));
        }
        return res;
    }
    
    private boolean isPossible(int row, int col, char[][] board, int n) {
        // same row backwards
        for (int j = 0; j <= col; j++) {
            if (board[row][j] == 'Q') return false;
        }
        
        // same col backwards
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        
        // diagonal1
        int i = row; 
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        
        // diagonal2
        i = row;
        j = col;
        while (j < n && i >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}
