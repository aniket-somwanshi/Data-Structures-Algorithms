// O(N) O(1)
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int res = 0;
        
        int i = 0;
        int j = 0;
        
        int ones = 0;
        int zeroes = 0;
        
        while (j < n) {
            if (nums[j] == 0) zeroes++;
            else ones++;
            
            // while it's invalid
            while (i <= j && zeroes > 1) {
                // try to make it valid,
                // by removing zeroes from left
                zeroes -= nums[i] == 0 ? 1 : 0;
                i++;
            }
            
            // this is valid window
            int lengthOfWindowOfOnes = (j-i+1) - zeroes;
            res = Math.max(res, lengthOfWindowOfOnes);
            j++;
        }
        
        
        // it there are no zeroes at all, then the answer will be 
        // total Ones - 1;
        ones = 0;
        zeroes = 0;
        for (int num: nums) {
            if (num == 0) zeroes++;
            else ones++;
        }
        
        if (zeroes == 0) return ones-1;
        
        return res;
    }
}

// // O(3N) O(2N)
// class Solution {
//     public int longestSubarray(int[] nums) {
//         int n = nums.length;
//         int[] prefix = new int[n];
//         int[] suffix = new int[n];
        
//         int longestLength = 0;
        
//         prefix[0] = nums[0] == 1 ? 1 : 0;
//         for (int i = 1; i < n; i++) {
//             prefix[i] = nums[i] == 1 ? prefix[i-1] + 1 : 0;        
//         }
        
//         suffix[n-1] = nums[n-1] == 1 ? 1 : 0;
//         for (int i = n-2; i >= 0; i--) {
//             suffix[i] = nums[i] == 1 ? suffix[i+1] + 1 : 0;     
//         }
        
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == 0) {
//                 int left = i-1 >= 0 ? prefix[i-1] : 0;
//                 int right = i+1 < n ? suffix[i+1] : 0;
//                 longestLength = Math.max(longestLength, left + right);
//             }
//         }
        
//         if (longestLength == 0) {
//             longestLength = Math.max(0, prefix[n-1]-1);
//         }
        
//         return longestLength;
//     }
// }