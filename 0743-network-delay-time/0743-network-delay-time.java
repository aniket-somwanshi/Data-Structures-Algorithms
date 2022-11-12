class Edge {
    int v;
    int w;
    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) adj.add(new ArrayList<>());
        
        for (int[] time: times) {
            adj.get(time[0]).add(new Edge(time[1], time[2]));
        }
        
        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {k, 0});
        
        while (!pq.isEmpty()) {
            int currentNode = pq.peek()[0];
            int currentWeight = pq.peek()[1];
            
            pq.poll();
            
            for (Edge e: adj.get(currentNode)) {
                int nextNode = e.v;
                int nextWeight = e.w;
                
                if (currentWeight + nextWeight < time[nextNode]) {
                    time[nextNode] = currentWeight + nextWeight;
                    pq.add(new int[]{nextNode, time[nextNode]});
                }
            }
        }
        
        int maxiTime = 0;
        for (int i = 1; i < n+1; i++) {
            if (time[i] == Integer.MAX_VALUE) return -1;
            maxiTime = Math.max(maxiTime, time[i]);
        }
        
        return maxiTime;
    }
}