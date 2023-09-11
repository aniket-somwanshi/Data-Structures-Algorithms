// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         int[] indegree = new int[numCourses];
//         List<Integer>[] graph = new LinkedList[numCourses];
//         for (int i = 0; i < numCourses; i++) {
//             graph[i] = new LinkedList<>();
//         }
//         for (int[] prerequisite: prerequisites) {
//             int a = prerequisite[0], b = prerequisite[1];
//             indegree[a]++;
//             graph[b].add(a);
//         }
//         int[] ans = new int[numCourses];
//         int finish = 0, idx = 0;
//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 0; i < numCourses; i++) {
//             if (indegree[i] == 0) {
//                 q.offer(i);
//             }
//         }
//         while (!q.isEmpty()) {
//             int b = q.poll();
//             finish++;
//             ans[idx] = b;
//             idx++;
//             for (int a : graph[b]) {
//                 indegree[a]--;
//                 if (indegree[a] == 0) {
//                     q.offer(a);
//                 }
//             }
//         }
//         return finish == numCourses ? ans : new int[0];
//     }
// }
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create adjacency list
        int[] indegree = new int[numCourses];
        List<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i]=new LinkedList<>();
        }
        
        // populate adj list
        for (List<Integer> dd:adj)
        System.out.println(dd);
        
        for (int[] p: prerequisites) {
            int a = p[0];
            int b = p[1];
            indegree[a]++;
            // System.out.println(u+"====>"+v);
            adj[b].add(a);
        }
        for (List<Integer> dd:adj)
        System.out.println(dd);
        
        int[] res = new int[numCourses];
        int resIndex = 0;
        
        // System.out.println(adj[0].get(0));
        
        // exhaust dependencies
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
    
        while (!q.isEmpty()) {
            
            int current = q.poll();
            System.out.println(current+" - "+indegree[current]);
            res[resIndex] = current;
            resIndex++;
            for (int v: adj[current]) {
                indegree[v]--;
                if (indegree[v] == 0) q.offer(v);
            }
        }
        
        return resIndex == numCourses ? res : new int[] {};
    }
}