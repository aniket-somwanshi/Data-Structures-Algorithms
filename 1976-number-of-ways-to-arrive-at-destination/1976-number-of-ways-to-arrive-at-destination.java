// O
class Edge {
    int v; int w;
    public Edge(int v, int w) {
        this.v = v; this.w = w;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Edge>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] road: roads) {
            adj.get(road[0]).add(new Edge(road[1], road[2]));
            adj.get(road[1]).add(new Edge(road[0], road[2]));
        }
        
        // ways
        int[] ways = new int[n];
        ways[0] = 1;
        
        // Dijkstra
        int destination = n-1;
        
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[0] = 0;
        
        Queue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.add(new Edge(0, 0));
        
        while (!pq.isEmpty()) {
            int currentNode = pq.peek().v;
            int currentWeight = pq.peek().w;
            
            pq.poll();
            
            for (Edge e: adj.get(currentNode)) {
                int nextNode = e.v;
                int nextEdgeWeight = e.w;
                
                
                
                if (currentWeight + nextEdgeWeight == time[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[currentNode]) % 1000000007;
                } 
                
                else if (currentWeight + nextEdgeWeight < time[nextNode]) {
                    time[nextNode] = currentWeight + nextEdgeWeight;
                    pq.add(new Edge(nextNode, time[nextNode]));
                    ways[nextNode] = ways[currentNode];
                }
            }
            
        }
         return ways[n-1]%1000000007;
    }
}