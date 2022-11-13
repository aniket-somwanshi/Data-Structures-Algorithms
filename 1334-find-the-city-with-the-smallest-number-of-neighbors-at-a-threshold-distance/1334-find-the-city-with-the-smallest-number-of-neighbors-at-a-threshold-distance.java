// O(N^3) O(N^2) -- N = number of cities/nodes
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // initialize distance matrix
        int[][] d = new int[n][n];
        int MAX = Integer.MAX_VALUE;
        for (int[] d1: d) Arrays.fill(d1, MAX);
        for (int i = 0; i < n; i++) d[i][i] = 0;
        for (int[] e: edges) {
            d[e[0]][e[1]] = e[2]; 
            d[e[1]][e[0]] = e[2];
        }
        
        // Floyd Warshall algo to find min dist between all nodes [i][j]
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][k] == MAX || d[j][k] == MAX) continue;
                    
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        
        int mini = MAX;
        int res = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                 if (d[i][j] <= distanceThreshold) count++;
            }
            if (count <= mini) {
                res = i;
                mini = count;
            }
        }
        return res;
    }
}