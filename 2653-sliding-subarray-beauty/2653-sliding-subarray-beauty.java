class Solution {
    int X;
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int offset = 50;
        this.X = x;
        int[] freq = new int[offset+offset+1];
        // manually compute freq of elements in first subarray
        for (int i = 0; i < k; i++) {
            freq[nums[i] + offset]++;
        }
        
        int[] res = new int[n-k+1];
        // slide the window
        int start = 0;
        int end = k-1;
        
        
        // calculate the beauty of the first window
        res[0] = getBeauty(freq);
        
        // slide the window
        for (int resIdx = 1; resIdx < (n-k+1); resIdx++) {
            end++;
            freq[nums[end]+offset]++;
            freq[nums[start]+offset]--;
            start++;
            res[resIdx] = getBeauty(freq);
        }
        
        return res;
    }
    
    private int getBeauty(int[] freq) {
        int numbersSeen = 0;
        for (int num = -50; num < 0; num++) {
            numbersSeen += freq[num+50];
            if (numbersSeen >= X) return num;
        }
        return 0;
    }
}