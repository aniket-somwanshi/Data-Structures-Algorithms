class Solution {
public:
    // Alternate question: Can the graph be colored with 2 colors such that
    // no to adjacent nodes have the same color
    // approach 1: BFS
//     bool isBipartite(vector<vector<int>>& graph) {
//         int n = graph.size();
//         vector<int> color (n, -1);
//         for (int i = 0; i < n; i++) {
//             if (color[i] == -1) { // not visited
//                 if (bfsUtil(i, graph, color) == false) return false;
//             }
//         }
//         return true;
//     }
    
//     bool bfsUtil(int node, vector<vector<int>>& graph, vector<int> &color) {
//         queue<int> q;
//         q.push(node);
//         color[node] = 0;
//         while (!q.empty()) {
//             int curr = q.front();
//             q.pop();
//             for (auto neighbour: graph[curr]) {
//                 if (color[neighbour] == -1) {
//                     color[neighbour] = (color[curr] + 1) % 2;
//                     q.push(neighbour);
//                 }
//                 else if (color[neighbour] == color[curr]) return false;
//             }
//         }
//         return true;
//     }
    
     // approach 2; DFS
    bool isBipartite(vector<vector<int>>& graph) {  
        int n = graph.size();
        vector<int> color(n, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) { // not yet visited
                if (dfsUtil(i, graph, color) == false) return false;
            }
        }
        return true;
    }
    
    bool dfsUtil(int node, vector<vector<int>> &graph, vector<int> &color) {
        if (color[node] == -1) color[node] = 0;
        
        for (auto neighbour: graph[node]) {
            if (color[neighbour] == -1) { 
                color[neighbour] = (color[node] + 1)%2; // opposite color
                if (dfsUtil(neighbour, graph, color) == false) return false;
            }
            else if (color[neighbour] == color[node]) return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
};