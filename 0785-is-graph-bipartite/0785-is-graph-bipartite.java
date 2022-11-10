// 
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Integer[] color = new Integer[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == null && isNonBipartite(i, 1, graph, color)) return false;
        }
        return true;
    }
    
    private boolean isNonBipartite(int node, int c, int[][] graph, Integer[] color) {
        color[node] = c;
        for (int nb: graph[node]) {
            if (color[nb] == null) {
                if (isNonBipartite(nb, flip(c), graph, color)) return true;
            }
            else if (color[nb] == c) return true;
        }
        return false;
    }
    
    private int flip(int i) {
        if (i == 1) return 2;
        if (i == 2) return 1;
        return -1;
    }
}
 
