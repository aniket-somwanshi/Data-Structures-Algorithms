// O(V+E) O(V+E) -- DSU union find
class DSU {
    int[] size;
    int[] rank;
    int[] parent;
    int count;
    public DSU(int n) {
        this.size = new int[n];
        this.rank = new int[n];
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
    }
    
    public boolean isSameComponent(int u, int v) {
        return findParent(u) == findParent(v);
    }
    
    private int findParent(int node) {
        if (parent[node] == node) return node;
        else return parent[node] = findParent(parent[node]);
    } 
    
    public void unionBySize(int u, int v) {
        int p1 = findParent(u);
        int p2 = findParent(v);
        
        if (p1 == p2) return;
        
        if (size[p1] < size[p2]) {
            // attach p1 to p2
            parent[p1] = p2;
            size[p2]++;
        }
        else {
            parent[p2] = p1;
            size[p1]++;
        }
        count--;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        DSU dsu = new DSU(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.unionBySize(i, j);
                } 
            }
        }
        
        return dsu.count;
    }
}



// O(V+E) O(V+E) -- dfs
// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
//         for (int from = 0; from < n; from++) {
//             for (int to = 0; to < n; to++) {
//                 if (isConnected[to][from] == 1 && from != to) {
//                     adj.get(from).add(to);
//                 }
//             }
//         }
        
//         int c = 0;
//         boolean[] visited = new boolean[n];
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 c++;
//                 dfs(i, adj, visited);
//             }
//         }
//         return c;
//     }
    
//     private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
//         visited[node] = true;
//         for (int neighbor: adj.get(node)) {
//             if (!visited[neighbor]) dfs(neighbor, adj, visited);
//         }
//     }
// }