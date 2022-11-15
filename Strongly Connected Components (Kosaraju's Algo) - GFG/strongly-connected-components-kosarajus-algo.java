//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj)
    {
        // topological sort
        Stack<Integer> st = getTopologicalSort(n, adj);
        
        // reverse edges
        ArrayList<ArrayList<Integer>> reverseAdj = getReverseAdj(n, adj);
        
        // traverse topologically
        // and count components  
        boolean[] visited = new boolean[n]; 
        int count = 0;
        
        while (!st.isEmpty()) {
            int i = st.pop();
            if (!visited[i]) {
                count++;
                dfs(i, reverseAdj, visited);
            }
        }
        return count;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int nb: adj.get(node)) {
            if (!visited[nb]) {
                dfs(nb, adj, visited);
            }
        }
    }
    
    private ArrayList<ArrayList<Integer>> getReverseAdj(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) res.add(new ArrayList<>());
        
        for (int from = 0; from < n; from++) {
            for (int to: adj.get(from)) {
                res.get(to).add(from);
            } 
        }
        return res;
    }
    
    private Stack<Integer> getTopologicalSort(int n, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) dfsTopo(i, adj, visited, st);
        }
        return st;
    }
    
    private void dfsTopo(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (int nb: adj.get(node)) {
            if (!visited[nb]) dfsTopo(nb, adj, visited, st);
        }
        st.push(node);
    }
}
