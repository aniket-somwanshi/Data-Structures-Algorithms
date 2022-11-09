class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int from = 0; from < n; from++) {
            for (int to = 0; to < n; to++) {
                if (isConnected[to][from] == 1 && from != to) {
                    adj.get(from).add(to);
                }
            }
        }
        
        int c = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                c++;
                dfs(i, adj, visited);
            }
        }
        return c;
    }
    
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor: adj.get(node)) {
            if (!visited[neighbor]) dfs(neighbor, adj, visited);
        }
    }
}