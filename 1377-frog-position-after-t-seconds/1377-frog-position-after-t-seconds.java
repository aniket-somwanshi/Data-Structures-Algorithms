class Pair {
    int node;
    double prob;
    public Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
    } 
}
class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        // reduce 1 from everything to make it zero-based indexing
        for (int i = 0; i < edges.length; i++) {
            edges[i][0] = edges[i][0]-1;
            edges[i][1] = edges[i][1]-1;
        }
        target = target - 1;
        
        List<List<Integer>> adj = new ArrayList<>(); 
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int time = 0;
        double probability = 0;
        Queue<Pair> q = new LinkedList<>(); // node, pobability
        q.add(new Pair(0, 1));
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                
                Pair current = q.poll();
                int currentNode = current.node;
                double currentProb = current.prob;
                System.out.print(currentNode + "-" +currentProb +" ");
                visited[currentNode] = true;
                
                if (currentNode == target && t == time) {
                    probability = currentProb;
                    return probability;
                }
                
                int options = 0;
                for (int neighbor: adj.get(currentNode)) {
                    if (!visited[neighbor]) options++;
                }
                if (options == 0 && currentNode == target)  {return currentProb;}
                if (options == 0) continue;
                
                System.out.println(1/options);
                double oneBy = Math.pow(options, -1);
                // double oneBy = 1/options;
                for (int neighbor: adj.get(currentNode)) {
                    if (!visited[neighbor]) {
                        q.add(new Pair(neighbor, 1D * (double)currentProb * (double)(oneBy)));
                    }
                }
                
            }
            time++;            
            if (time > t) break;
            System.out.println();
        }
        
        return probability;
    }
}