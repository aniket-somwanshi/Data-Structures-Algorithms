class Solution {
    List<List<Integer>> adj;
    int n;
    public int countCompleteComponents(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();
        // create adj list
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // traverse component by component
        int completeComponents = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> nodesInComponent = new ArrayList<>();
                getNodesInComponent(i, visited, nodesInComponent);
                boolean isCompleteComponent = true;
                for (int node: nodesInComponent) {
                    if (adj.get(node).size() < nodesInComponent.size()-1) {
                        isCompleteComponent = false;
                        break;
                    }
                }
                if (isCompleteComponent) completeComponents++;
            }
        }
        
        return completeComponents;
    }
    
    private void getNodesInComponent(int node, boolean[] visited, List<Integer> nodesInComponent) {
        visited[node] = true;
        nodesInComponent.add(node);
        for (int v: adj.get(node)) {
            if (!visited[v]) {
                getNodesInComponent(v, visited, nodesInComponent);
            }
        }
    }
}