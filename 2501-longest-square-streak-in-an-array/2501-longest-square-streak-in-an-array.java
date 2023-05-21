class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        int maxiLength = -1;
        
        Arrays.sort(nums);
        Map<Integer, Integer> score = new HashMap<>();
        
        for (int i = n-1; i >= 0; i--) {
            int currentScore = 1;
            if (score.containsKey(nums[i]*nums[i])) {
                currentScore += score.get(nums[i]*nums[i]);
            }
            score.put(nums[i], currentScore);
            if (currentScore > 1) maxiLength = Math.max(maxiLength, currentScore);
        }
        
        return maxiLength;
    }
}