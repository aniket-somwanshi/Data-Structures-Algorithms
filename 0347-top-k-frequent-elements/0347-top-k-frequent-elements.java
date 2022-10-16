// Pair class
	class Pair <T, U>{
		T first;
		U second;
		public Pair(T first, U second) {
			this.first = first;
			this.second = second;
		}
	}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
        (a, b) -> a.first - b.first
        );
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
//         for (int name: map.keySet()) {
//     int key = name;
//     int value = map.get(name);
//     System.out.println(key + " " + value);
// }
        
        for (int num: map.keySet()) {
            minHeap.add(new Pair(map.get(num), num));
            if (minHeap.size() > k) {
                //System.out.println(minHeap.peek().first);
                minHeap.poll();
            }
        }
        
        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll().second;
        }
        return res;
    }
}