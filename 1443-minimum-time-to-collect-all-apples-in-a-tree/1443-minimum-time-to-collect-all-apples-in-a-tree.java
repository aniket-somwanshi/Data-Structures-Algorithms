class Solution {
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // create the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        
        // initialize adj list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // create continous tree rather than a disconnected tree
        // connect to already connected nodes, by keeping a visited array
        boolean[] isConnected = new boolean[n];
        Arrays.fill(isConnected, false);
        
        // create adj list
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            if (isConnected[u] == false && isConnected[v] == true) {
                adj.get(v).add(u);
            }
            else {
                adj.get(u).add(v);
            }
            isConnected[u] = true;
            isConnected[v] = true;
        }
        
        return dfs(0, hasApple, adj) * 2;
    }
    
    private int dfs(int node, List<Boolean> hasApple, List<List<Integer>> adj) {
        int childrenDepthTillLastApple = 0;
        for (int child: adj.get(node)) {
            childrenDepthTillLastApple += dfs(child, hasApple, adj);
        }
        if (node == 0) return childrenDepthTillLastApple;
        if (childrenDepthTillLastApple == 0) {
            if (hasApple.get(node) == true) return 1;
            else return 0;
        }
        else return childrenDepthTillLastApple + 1;
    }
    
}












