class Solution {
    public int findLeastNumOfUniqueInts(int[] a, int k) {
        // map freq
        // heap based on min freq
        // remove if we can
        Map<Integer, Integer> map = new HashMap<>();
        int c = 0;
        for (int num: a) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                c++;
                map.put(num, 1);
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[1]-y[1]); // [num, freq]
        
        for (int num: map.keySet()) pq.add(new int[] {num, map.get(num)});
        
        while (k > 0) {
            int[] curr = pq.poll();
            if (curr[1] <= k) {
                k -= curr[1];
                c--;
            }
            else break;
        }
        
        return c;
    }
}