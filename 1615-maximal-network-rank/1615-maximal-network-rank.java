class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int[] counts = new int[n];
        int[][] connected = new int[n][n];
        int maxRank = 0;
        
        for (int i = 0; i < roads.length; i++) {
            counts[roads[i][0]]++;
            counts[roads[i][1]]++;
            connected[roads[i][0]][roads[i][1]] = 1;
            connected[roads[i][1]][roads[i][0]] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                maxRank = Math.max(maxRank, counts[i]+counts[j]-connected[i][j]);
            }
        }
        
        return maxRank;
    }
}