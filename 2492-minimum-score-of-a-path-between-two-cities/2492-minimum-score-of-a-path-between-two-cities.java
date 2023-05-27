class Solution {
    int miniEdge = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        // initialize adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());   
        }
        
        // populate arraylist
        for (int[] road: roads) {
            adj.get(road[0]).add(new int[] {road[1], road[2]});
            adj.get(road[1]).add(new int[] {road[0], road[2]});
        }
        
        // traverse each component
        boolean[] visited = new boolean[n+1];
        dfs(1, adj, visited);
        dfs(n, adj, visited);
        return miniEdge;
    }
    
    private void dfs(int node, Map<Integer, List<int[]>> adj, boolean[] visited) {
        visited[node] = true;
        for (int[] neighbor: adj.get(node)) {
            miniEdge = Math.min(miniEdge, neighbor[1]);
            if (!visited[neighbor[0]]) {
                
                dfs(neighbor[0], adj, visited);
            }
        }
    }
}