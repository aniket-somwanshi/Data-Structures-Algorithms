class Solution {
    // O(N) O(N)
        public int subarraySum(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            map.put(0, 1);
            int runningSum = 0;
            for (int num: nums) {
            runningSum += num;
            if (map.containsKey(runningSum - k)) {
            res += map.get(runningSum - k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
    return res;
    }
}

