class Solution {
    // O(N) O(N)
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int currentSum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            if (currentSum == goal) res++;
            if (currentSum - goal >= 0 && map.containsKey(currentSum-goal)) {
                res += map.get(currentSum-goal);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return res;
    }
}

