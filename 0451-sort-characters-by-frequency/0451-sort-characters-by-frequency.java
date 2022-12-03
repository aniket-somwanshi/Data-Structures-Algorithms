class Solution {
    // O(N + 256*log(256) + N) O(256 + 256)
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>( (a, b) -> map.get(b) - map.get(a) );
        pq.addAll(map.keySet());
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Character current = pq.poll();
            int frequency = map.get(current);
            for (int i = 0; i < frequency; i++) {
                sb.append(current);
            }
        }
        return sb.toString();
    }
}