class Solution {
    // O(V+E) O(V)
    // bipartite check
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];
        int[] colors = new int[n + 1];
        for(int i = 0; i < n + 1; i++)
            graph[i] = new LinkedList();
        
        for(int[] edge: dislikes)
        {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        for(int i = 1; i < n + 1; i++)
        {
            if(dfs(i, colors, graph, 1, 0))
                return false;
        }
        
        return true;
    }
    
    private boolean dfs(int vertex, int[] colors, List<Integer>[] graph, int current, int prev)
    {
        if(colors[vertex] != 0)
            return colors[vertex] == prev;
        
        colors[vertex] = current;
        
        for(int nodes: graph[vertex])
        {
            if(dfs(nodes, colors, graph, -current, colors[vertex]))
                return true;
        }
        
        return false;
    }
}