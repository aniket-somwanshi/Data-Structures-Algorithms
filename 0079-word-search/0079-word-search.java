class Solution {
    private final int[][] dir = new int[][] {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    }; 
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (f(0, i, j, board, word)) return true;
            }
        }
        return false;
    }
    
    private boolean f(int index, int i, int j, char[][] board, String word) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(index)) return false;
        
        // mark visited
        char temp = board[i][j];
        board[i][j] = '#';
        
        // check in all 4 directions if this
        for (int d = 0; d < dir.length; d++) {
            int newX = i + dir[d][0];
            int newY = j + dir[d][1];
            
            if (f(index+1, newX, newY, board, word)) return true;
        }    
        
        // mark unvisited
        board[i][j] = temp;
        return false;
    }
}