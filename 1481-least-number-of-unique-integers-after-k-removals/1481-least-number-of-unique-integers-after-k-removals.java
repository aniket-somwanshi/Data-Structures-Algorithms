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
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // [num, freq]
        
        for (int num: map.keySet()) pq.add(map.get(num));
        
        while (k > 0 && !pq.isEmpty()) {
            k -= pq.poll();
        }
        
        return k < 0 ? pq.size()+1 : pq.size();
    }
}