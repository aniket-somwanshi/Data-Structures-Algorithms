class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // create a adj list or use map for graph
        // assign employees under each manager
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < manager.length; i++) {
            if(manager[i] == -1) continue;
            // graph.putIfAbsent(manager[i], new ArrayList<Integer>());
            // graph.get(manager[i]).add(i);
            graph.computeIfAbsent(manager[i], x -> new ArrayList<>()).add(i);
        }
        
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        //start with the head
        q.add(new int[] {headID, 0});
        
        // run a bfs and count the time taken for informing everyone
        while(!q.isEmpty()) {
            int curr = q.peek()[0];
            int t = q.poll()[1];
            time = Math.max(time, t);
            
            // if there are no subordinates, leave
            if(graph.get(curr) == null) continue;
            
            // add next values to the queue with time+informtime
            for(int nxt: graph.get(curr)) {
                int nxtTime = t + informTime[curr];
                q.add(new int[] {nxt, nxtTime});
            }
        }
        
        return time;
    }
}