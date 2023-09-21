class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int j = n-i-1;
            prefix[i] = nums[i] * (i-1 >= 0 ? prefix[i-1] : 1); 
            suffix[j] = nums[j] * (j+1 < n ? suffix[j+1] : 1); 
        }
        
        for (int i = 0; i < n; i++) {
            int prev = i-1 >= 0 ? prefix[i-1] : 1;
            int next = i+1 < n ? suffix[i+1] : 1;
            res[i] = prev * next;
        }
        return res;
    }
}