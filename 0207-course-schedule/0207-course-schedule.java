class Pair {
    int x; int y;
    public Pair(int xx, int yy) {
        x = xx;
        y = yy;
    }
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        int[] indegree = new int[numCourses];
        
        for (int[] p: prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(new Pair(i, 0));
        }
        
        if (q.isEmpty()) return false;
        
        int numVisited = 0;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int node = current.x;
            int ind = current.y;
            
            numVisited++;
            
            for (int nb: adj.get(node)) {
                if (--indegree[nb] == 0) q.add(new Pair(nb, 0));
            }
        }
        
        return numVisited == numCourses;
    }
}