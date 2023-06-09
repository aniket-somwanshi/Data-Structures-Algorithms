class Solution {
    public int[] avoidFlood(int[] a) {
        int n = a.length;
        Map<Integer, Integer> lastOccurance = new HashMap<>();
        int[] nextOccurance = new int[n];
        for (int i = n-1; i >= 0; i--) {
            if (a[i] == 0) continue;
            if (!lastOccurance.containsKey(a[i])) {
                nextOccurance[i] = n;
                lastOccurance.put(a[i], i);
            }
            else {
                nextOccurance[i] = lastOccurance.get(a[i]);
                lastOccurance.put(a[i], i);
            }
        }
        
        int[] res = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->nextOccurance[x]-nextOccurance[y]);
        // pq stores the indices sorted by closes nextOccurance first
        
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                // dry out the lake which is nearest next coming up
                if (pq.isEmpty()) {
                    res[i] = 1; // any lake for fucks sake 
                }
                else {
                    int idx = pq.poll();
                    visited.remove(a[idx]);
                    res[i] = a[idx];
                }
            }
            else {
                if (visited.contains(a[i])) return new int[] {};
                pq.add(i);
                visited.add(a[i]);
                res[i] = -1;
            }
        }
        
        return res;
    }
}