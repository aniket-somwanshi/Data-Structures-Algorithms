class Solution {
    /*
    O(fuck knows) O(N^N)
    Simple BFS
    Try all possible snakes and ladders 
    When we reach n^2 return moves until now (levels of BFS)
    we start our BFS with position 1
    we will move forward using the die in 1D 
    Only when we need to check if there is snake or ladder at the given 1D position,
    we'll convert it to 2d and check in the board[][] 
    */
    public int snakesAndLadders(int[][] board) {
        // 
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        // snakes and ladders go up and down so we don't wanna revisit positions
        boolean[] visited = new boolean[n*n+1]; // +1 cos the 1D values start from 1 and not 0
        int moves = 0; // levels in our BFS
        
        while (q.isEmpty() == false) {
            int size = q.size();
            while (size-- > 0) {
                int position = q.poll();
                if (visited[position] == true) continue; // don't revisit
                visited[position] = true;
                if (position == n*n) return moves; // reached the end
                // roll the dice and visit all of the posibilities
                for (int dice = 1; dice <= 6 && position + dice <= n*n; dice++) {
                    int nextPosition = position + dice;
                    int valueOnNextPosition = getValueFromTheBoard(nextPosition, board);
                    // if this is a snake or a ladder
                    if (valueOnNextPosition > 0) nextPosition = valueOnNextPosition;
                    // else just go forward that many 'dice' steps
                    // add this nextPosition to the queue to advance further
                    if (visited[nextPosition] == false) q.add(nextPosition);
                }
            }
            moves++;
        }
        // no way home
        // if all the possible paths are explored and as we have visited array
        // we won't keep cycling there. So if we no paths work out, it's impossible to reach end
        // (this is probably cos there's bare snakes from 94 to 99)
        return -1;
    }
    
    private int getValueFromTheBoard(int position, int[][] board) {
        int rows = board.length;
        int rowNumber = (position-1) / rows;
        // but as the first row starts from the bottom instead of the top,
        // the actual row number is
        int i = (rows - 1) - rowNumber;
        int j = rowNumber % 2 == 0 ? (position-1) - rowNumber * rows : rows + rowNumber * rows - position;
        return board[i][j];
    }
}