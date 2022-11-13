//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair {
    int v;
    int w;
    public Pair(int w, int v) {
        this.w = w; this.v = v;
    }
}
class Solution {
static int spanningTree(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
        (a, b)->a.w - b.w);
        
    boolean[] vis = new boolean[n];
    
    pq.add(new Pair(0, 0));
    int sum = 0;
    while (!pq.isEmpty()) {
        int w = pq.peek().w;
        int v = pq.peek().v;
        pq.poll();
        
        if (vis[v]) continue;
        
        vis[v] = true;
        sum += w;
        
        for (List<Integer> e: adj.get(v)) {
            int nextW = e.get(1);
            int nextV = e.get(0);
            
            if (!vis[nextV]) {
                pq.add(new Pair(nextW, nextV));
            }
        }
    }
    return sum;
}
}