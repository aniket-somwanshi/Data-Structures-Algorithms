class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int res = 1;
        Map<Integer, Integer>[] map = new HashMap[n];
        
        for (int i = 0; i < n; i++) {
            int currentElement = nums[i];
            map[i] = new HashMap<>(); // initialize
            Map<Integer, Integer> currentMap = map[i]; // to be constructed now
            
            for (int j = 0; j < i; j++) {
                int difference = currentElement - nums[j];
                Map<Integer, Integer> prevMap = map[j];
                int updatedValue = prevMap.getOrDefault(difference, 0) + 1;
                currentMap.put(difference, updatedValue);
                map[i] = currentMap;
                res = Math.max(res, updatedValue);
            }
        }
        
        return res + 1;
    }
}