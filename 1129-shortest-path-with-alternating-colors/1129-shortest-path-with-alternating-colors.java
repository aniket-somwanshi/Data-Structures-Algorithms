class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        Map<Integer, Set<Integer>> reds1 = new HashMap();
        Map<Integer, Set<Integer>> blues1 = new HashMap();
        
        Map<Integer, Set<Integer>> reds2 = new HashMap();
        Map<Integer, Set<Integer>> blues2 = new HashMap();
        for (int[] red: redEdges) {
            reds1.computeIfAbsent(red[0], e -> new HashSet<Integer>()).add(red[1]);
            reds2.computeIfAbsent(red[0], e -> new HashSet<Integer>()).add(red[1]);
        }
        for (int[] blue: blueEdges) {
            blues1.computeIfAbsent(blue[0], e -> new HashSet<Integer>()).add(blue[1]);
            blues2.computeIfAbsent(blue[0], e -> new HashSet<Integer>()).add(blue[1]);
        }
        
        bfs(reds1, blues1, min, true, n);
        bfs(reds2, blues2, min, false, n);
        for (int i = 0; i < n; i++) {
            if (min[i] == Integer.MAX_VALUE) min[i] = -1;
        }
        return min;
    }
    
    private void bfs(Map<Integer, Set<Integer>> reds, 
                    Map<Integer, Set<Integer>> blues,
                    int[] min, boolean color, int n
                    ) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int curr = queue.remove();
                Set<Integer> nxt;
                if (color) {
                    nxt = reds.getOrDefault(curr, new HashSet<>());
                } else {
                    nxt = blues.getOrDefault(curr, new HashSet<>());
                }
                min[curr] = Math.min(min[curr], distance);
                List<Integer> rms = new ArrayList<>();
                for (int nx : nxt) {
                    queue.add(nx);
                    rms.add(nx);
                }
                nxt.removeAll(rms);
                
                size--;
            }
            color = !color;
            distance++;
        }
    }
}