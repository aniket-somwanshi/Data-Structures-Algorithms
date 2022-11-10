class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // topological sort
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        for (int[] p: prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        
        // if there is a cycle, return empty array
        if (isCyclePresent(adj, numCourses)) return new int[]{};
        
        
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[numCourses];
        Arrays.fill(vis, false);
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) dfs(i, adj, s, vis);
        }
        
        int[] res = new int[numCourses];
        int i = 0;
        while (!s.isEmpty()) {
            res[i++] = s.pop();
        }
        return res;
    }
    
    private boolean isCyclePresent(List<List<Integer>> adj, int n) {
        int[] state = new int[n];
        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                if (isCycle(i, adj, state)) return true;
            }
        }
        return false;
    }
    
    private boolean isCycle(int node, List<List<Integer>> adj, int[] state) {
        state[node] = 1;
        for (int nb: adj.get(node)) {
            if (state[nb] == 1) return true;
            else if (state[nb] == 0) {
                if (isCycle(nb, adj, state)) return true;
            }
        }
        state[node] = 2;
        return false;
    }
    int i = 0;
    private void dfs(int node, List<List<Integer>> adj, Stack<Integer> s, boolean[] vis) {
        vis[node] = true;
        for (int nb: adj.get(node)) {
            if (!vis[nb]) {
                dfs(nb, adj, s, vis);
            }
        }
        System.out.println(node);
        s.push(node);
    }
}