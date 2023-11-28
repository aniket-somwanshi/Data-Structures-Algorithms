// O(V+E) O(V) dfs
class Solution {
    List<List<Integer>> adj;
    int n;
    List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.n = n;
        this.adj = new ArrayList<>();
        this.hasApple = hasApple;
        
        // create adj list
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // dfs
        Integer res = dfs(0, -1);
        return res == null ? 0 : res-2;
    }
    
    private Integer dfs(int node, int parent) {        
        // get results from the below level
        int costFromChildren = 0;
        
        for (int v: adj.get(node)) {
            // skip the parent back edge
            if (v == parent) continue;
            Integer childResult = dfs(v, node);
            costFromChildren += childResult != null ? childResult : 0;
        }
        
        // send null above if there is no costFromChildren 
        // and current node is also not an apple
        
        if (costFromChildren == 0 && !hasApple.get(node)) return null;
        
        return costFromChildren + 2;
    }
}