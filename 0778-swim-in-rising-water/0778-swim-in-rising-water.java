// (N^2)*log(N^2)
// Dijkstra's algorithm
// greedily take the node with the smallest running maximum
class Node {
     int runningCost;
     int i;
     int j;
    public Node(int mc, int i, int j) {
        this.runningCost = mc;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    private int[][] dirs = new int[][] {
        {0,1},{1,0},{-1,0},{0,-1}
    };
    public int swimInWater(int[][] a) {
        int n = a.length;
        int res = Integer.MAX_VALUE;
        
        boolean[][] visited = new boolean[n][n];
        Queue<Node> pq = new PriorityQueue<>((a1,a2)->a1.runningCost - a2.runningCost); // sort asc by runningCost
        pq.add(new Node(a[0][0], 0, 0)); // add source into pq
        visited[0][0] = true; // mark it as visited
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            // if we have found the destination, update the res
            if (current.i == n-1 && current.j == n-1) {
                return current.runningCost;
            }
            
            for (int[] dir: dirs) {
                int newX = current.i + dir[0];
                int newY = current.j + dir[1];
                
                // check if out of bounds or already visited
                if (newX < 0 || newY < 0 || newX >= n || newY >= n) continue;
                if (visited[newX][newY]) continue;
                
                visited[newX][newY] = true;
                int newRunningCost = Math.max(current.runningCost, a[newX][newY]);
                pq.add(new Node(newRunningCost, newX, newY));
            }
        }
        
        return -1;
    }
}

