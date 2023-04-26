class Solution {
    public int findLucky(int[] arr) {
        // Store frequencies of all numbers in a map
        // Traverse the map and find the maximum lucky number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int res = -1;
        for (int key: map.keySet()) {
            if (key == map.get(key)) {
                res = Math.max(res, key);
            }
        }
        return res;
    }
}