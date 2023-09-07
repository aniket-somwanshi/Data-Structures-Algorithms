class Solution {
    public int maxProduct(int[] nums) {
        int maxi = nums[0];
        int mini = nums[0];
        int res = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            
            int newMaxi = Math.max(maxi * num, Math.max(mini * num, num));
            int newMini = Math.min(mini * num, Math.min(maxi * num, num));
            
            maxi = newMaxi;
            mini = newMini;
            
            res = Math.max(res, maxi);
        }
        
        return res;
    }
}