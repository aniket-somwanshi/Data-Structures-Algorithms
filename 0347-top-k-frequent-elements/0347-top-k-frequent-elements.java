// O(N+ NlogK + (N-k)logK + KlogK) O(N+K)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->map.get(x)-map.get(y));
        for (int num: map.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        
        int[] res = new int[k];
        int i=0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }
}