class Solution {
    public boolean validTicTacToe(String[] board) {
        // n = number of moves played
        // 1. number of "X" should be n/2 + 1 for odd n 
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') xCount++;
                else if (board[i].charAt(j) == 'O') oCount++;
            }
        }
        int movesCount = xCount + oCount;
        if (movesCount % 2 == 0 && xCount != oCount) return false;
        if (movesCount % 2 != 0 && xCount != (movesCount/2) + 1) return false;
        
        // 2. if both players have won, it's invalid
        if (hasWon(board, 'X') && hasWon(board, 'O')) return false;
        
        // 3. if "X" wins, after that "O" cant play so no. of X's should be greater than Os, as X started
        // if "O" wins, after that "X" cant play so no. of O's should be equal to Xs 
        if ((hasWon(board, 'X') && xCount <= oCount) || (hasWon(board, 'O') && xCount > oCount)) return false;
        
        return true;
    }
    
    private boolean hasWon(String[] board, char target) {
        // rows
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == target && 
                board[i].charAt(0) == board[i].charAt(1) && 
                board[i].charAt(1) == board[i].charAt(2)) return true;
        }
        // cols
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == target && 
                board[0].charAt(i) == board[1].charAt(i) && 
                board[1].charAt(i) == board[2].charAt(i)) return true;
        }
        // diagonals
        if (board[0].charAt(0) == target && 
            board[0].charAt(0) == board[1].charAt(1) && 
            board[1].charAt(1) == board[2].charAt(2))
                return true;
        
        if (board[0].charAt(2) == target && 
            board[0].charAt(2) == board[1].charAt(1) && 
            board[1].charAt(1) == board[2].charAt(0))
                return true;
        
        
        return false;
    }
}