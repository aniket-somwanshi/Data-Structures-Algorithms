class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        Boolean[] memo = new Boolean[n];
        boolean[] visited = new boolean[n];
        
        List<Integer> res = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                isSafe(i, graph, memo, visited);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (memo[i]) res.add(i);
        }
        return res;
    }
    
    private boolean isSafe(int node, int[][] graph, Boolean[] memo, boolean[] visited) {
        visited[node] = true;
        
        if (memo[node] != null) return memo[node];
        
        if (graph[node].length == 0) {
            return memo[node] = true; 
        }
        
        for (int nb: graph[node]) {
            if (visited[nb] && (memo[nb] == null || !memo[nb])){
                return memo[node] = false; 
            }
            else if (isSafe(nb, graph, memo, visited) == false) {
                return memo[node] = false;
            }  
        }
        return memo[node] = true;
    }
}