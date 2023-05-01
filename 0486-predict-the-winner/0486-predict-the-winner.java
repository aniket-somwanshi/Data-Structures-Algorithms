class Solution {
    int[] nums;
    int n;
    public boolean PredictTheWinner(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        
        return f(0, n-1, true) >= 0;
    }
    
    private int f(int start, int end, boolean isPlayer1sTurn) {
        if (start > end) {
            return 0;
        }
        
        int res = 0;
        
        if (isPlayer1sTurn) {
            res = Math.max(nums[start] + f(start+1, end, false),
                          nums[end] + f(start, end-1, false));
        }
        else {
            res = Math.min(-nums[start] + f(start+1, end, true),
                          -nums[end] + f(start, end-1, true));
        }
        
        return res;
    }
}