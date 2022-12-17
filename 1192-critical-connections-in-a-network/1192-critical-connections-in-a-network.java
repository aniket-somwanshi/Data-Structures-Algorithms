class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // create adj list from adj matrix
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (List<Integer> connection: connections) {
            int node1 = connection.get(0);
            int node2 = connection.get(1);
            
            adj.get(node1).add(node2);
            adj.get(node2).add(node1); // undirected graph    
        }
        
        List<List<Integer>> bridges = getBridges( n, adj);
        
        return bridges;
    }
    
    int time;
    List<List<Integer>> bridges;
    int[] in;
    int[] reach;
    boolean[] visited;
    private List<List<Integer>> getBridges(int n, List<List<Integer>> adj) {
        bridges = new ArrayList<>();
        time = 0;
        in = new int[n];
        reach = new int[n];
        visited = new boolean[n];
        
        dfs(0, adj, -1);
        
        return bridges;
    }
    
    private void dfs(int node, List<List<Integer>> adj, int parent) {
        visited[node] = true;
        in[node] = time;
        reach[node] = time;
        time++;
        for (int nb: adj.get(node)) {
            if (nb == parent) continue;
            
            if (visited[nb]) { // back edge
                reach[node] = Math.min(reach[node], in[nb]);
                continue;
            }
            
            dfs(nb, adj, node);
            if (reach[nb] > in[node]) {
                // bridge found
                List<Integer> bridge = new ArrayList<>();
                bridge.add(node);
                bridge.add(nb);
                bridges.add(bridge);
            }
            reach[node] = Math.min(reach[node], reach[nb]);
        }
    }
}