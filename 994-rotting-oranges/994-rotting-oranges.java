class Solution {
    // O(M*N) O(M*N)
    // we use Bfs because we need to utilize explosions of all the oranges 
    // at the same time
    public int orangesRotting(int[][] a) {
        // 0 - empty
        // 1 - fresh
        // 2 - rotten
        int rows = a.length;
        int cols = a[0].length;
        Queue<Pair<Integer, Integer>> q= new LinkedList<>();
        // traverse and add all rotten oranges into queue
        // also count number of fresh oranges 
        int fresh_left = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == 1) fresh_left++;
                else if (a[i][j] == 2) q.add(new Pair<>(i,j));
            }
        }
        if (fresh_left == 0) return 0;
        // while q not empty 
        // pop rotten oranges and propogate them
        // if total fresh oranges left == 0 return time  
        // add just rotten oranges to qeueue
        int time = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            // propogate all rotten oranges at this instance of time
            while (size-- > 0) {
                Pair<Integer, Integer> bomb = q.poll();
                int i = bomb.getKey();
                int j = bomb.getValue();
                // propogate this rotten orange
                if (didDamage(a, i+1, j)) {
                    // if it rotten a fresh orange
                    if (--fresh_left == 0) return time; 
                    // this position was fresh but got rotten
                    // so it will propogate in next time interval
                    q.add(new Pair<>(i+1, j));
                }
                if (didDamage(a, i, j+1)) {
                    if (--fresh_left == 0) return time; 
                    q.add(new Pair<>(i, j+1));
                }
                if (didDamage(a, i-1, j)) {
                    if (--fresh_left == 0) return time; 
                     q.add(new Pair<>(i-1, j));
                }
                if (didDamage(a, i, j-1)) {
                    if (--fresh_left == 0) return time; 
                    q.add(new Pair<>(i, j-1));
                }
            }
            
            time++;
        }
        // if all rotten oranges propogated and exploded, and still fresh ones are left so
        return -1;
    }
    
    private boolean didDamage(int[][] a, int i, int j) {
        // if out of bounds, did'nt do damage
        if (i >= a.length || i < 0) return false;
        if (j >= a[0].length || j < 0) return false;
        // if orange doesn't exist herer, no damaage
        if (a[i][j] == 0) return false;
        // if this orange was already rotten, no damage 
        else if (a[i][j] == 2) return false;
        // if this oragne was fresh before,
        // and is getting rotten now, damage is done
        else if (a[i][j] == 1) {
            a[i][j] = 2;
            return true;
        }
        return true;
    }
}