//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


class Edge {
    int v; int d;
    public Edge(int v, int d) {
        this.v = v;
        this.d = d;
    }
}
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
	    int source = 0;
	    List<List<Edge>> adj = new ArrayList<>();
	    for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
	    for (int[] e: edges) adj.get(e[0]).add(new Edge(e[1], e[2]));
	    
	    return shortestPathAnySource(N, adj, source);
	}
	
	private int[] shortestPathAnySource(int n, List<List<Edge>> adj, int source) {
	    // topological sort
	    Stack<Integer> st = new Stack<>();
	    boolean[] visited = new boolean[n];
	    for (int i = 0; i < n; i++) {
	        if (!visited[i]) topoSortDFS(i, adj, visited, st);
	    }
	    
	    // the nodes before our source are of no use so delete them
	    while (!st.isEmpty() && st.peek() != source) st.pop();
	    
	    int[] distance = new int[n];
	    Arrays.fill(distance, Integer.MAX_VALUE);
	    distance[source] = 0;
	    
	    // traverse all toposorted nodes, and relax all the edges
	    while (!st.isEmpty()) {
	        int currentNode = st.pop();
	        
	        for (Edge e: adj.get(currentNode)) {
	            int u = currentNode;
	            int v = e.v;
	            int edgeWeight = e.d;
	            
	            if (distance[u] + edgeWeight < distance[v]) {
	                distance[v] = distance[u] + edgeWeight;
	            }
	        }
	        
	    }
	    
	    for (int i = 0; i < n; i++) if (distance[i] == Integer.MAX_VALUE) distance[i] = -1;
	    
	    return distance;
	}
	
	private void topoSortDFS(int node, List<List<Edge>> adj, boolean[] visited, Stack<Integer> st) {
	    visited[node] = true;
	    for (Edge e: adj.get(node)) {
	        if (!visited[e.v]) {
	            topoSortDFS(e.v, adj, visited, st);
	        }
	    }
	    st.push(node);
	}
}