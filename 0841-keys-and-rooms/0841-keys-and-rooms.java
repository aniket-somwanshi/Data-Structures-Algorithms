class Solution {
    // O(V+E) O(2V)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // starting from 0, use dfs to visit unvisited nodes
        // at the end if any node is left unvisited, return false else true
        
        
        boolean[] visited = new boolean[rooms.size()];
        Arrays.fill(visited, false);
        dfs(0, rooms, visited);
        
        for (boolean b: visited) 
            if (b == false) return false;
        
        return true;
    }
    
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor: adj.get(node)) {
            if (visited[neighbor] == false) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
