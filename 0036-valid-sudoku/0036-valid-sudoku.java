class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character> > rowToSet = new HashMap<>(); // row to set, 9 rows 0 to 8
        Map<Integer, Set<Character> > colToSet = new HashMap<>(); // column to set, 9 columns 0 to 8
        Map<Integer, Set<Character> > segToSet = new HashMap<>(); // segment to set, 9 segments 0 to 8
        
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                
                if(board[row][col] == '.'){
                    continue;
                }
                
                Set<Character> rowSet = rowToSet.getOrDefault(row, new HashSet<>());
                Set<Character> colSet = colToSet.getOrDefault(col, new HashSet<>());
                int segment = getSegment(row, col);
                Set<Character> segSet = segToSet.getOrDefault(segment, new HashSet<>());
                
                if(rowSet.contains(board[row][col]) || colSet.contains(board[row][col]) || segSet.contains(board[row][col])){
                    return false;
                } else {
                    rowSet.add(board[row][col]);
                    rowToSet.put(row, rowSet);
                    
                    colSet.add(board[row][col]);
                    colToSet.put(col, colSet);
                    
                    segSet.add(board[row][col]);
                    segToSet.put(segment, segSet);
                }
            }
        }
        return true;        
    }
    
    private int getSegment(int row, int col){
        int segmentRow = row / 3;
        int segmentCol = col / 3;
        return segmentCol + segmentRow * 3;
    }
}