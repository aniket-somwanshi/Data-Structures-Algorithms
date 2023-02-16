class Solution {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(getLowestMoves(0, nums), getLowestMoves(1, nums));             
    }
    
    private int getLowestMoves(int start, int[] a) {
        int moves = 0;
        
        for (int i = start; i < a.length; i += 2) {
            int miniFromNeighbours = Math.min(getValue(a, i-1), getValue(a, i+1));
            if (a[i] >= miniFromNeighbours) {
                moves += Math.abs(a[i] - miniFromNeighbours) + 1;
            }
        }
        
        return moves;
    }
    
    private int getValue(int[] a, int i) {
        return i < 0 || i >= a.length ? Integer.MAX_VALUE : a[i];
    } 
}