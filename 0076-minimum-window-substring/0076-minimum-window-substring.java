// O(2(N+M)) O(2*(256)) -- sliding window
// maintain sliding window which has valid freq as desired
// when found a valid window, try to shrink it from front
// to get an even smaller window
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        char[] a = s.toCharArray();
        char[] target = t.toCharArray();
        
        // maps
        int[] freq = new int[256];
        int[] targetFreq = new int[256];
        
        // get target's frequencies
        for (int i = 0; i < target.length; i++) {
            targetFreq[target[i]]++;
        }
        
        
        int i = 0;
        int j = 0;
        
        int[] mini = new int[] { Integer.MAX_VALUE }; // { mini, start, end }
        
        while (j < n) {
            freq[a[j]]++;
            // if we have found a valid winodw, 
            // update the res and try to shrink the window to get a better ans
            // do this till make the window invalid again
            while (i <= j && isValid(freq, targetFreq)) {
                if (j-i+1 < mini[0]) {
                    mini = new int[] {j-i+1, i, j};
                }
                freq[a[i]]--;
                i++;
            }
            // at this point the window is invalid
            j++;
        }
        
        return mini[0] == Integer.MAX_VALUE ? "" : s.substring(mini[1], mini[2]+1);
    }
    
    private boolean isValid(int[] freq, int[] targetFreq) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] < targetFreq[i]) return false;
        }
        return true;
    }
}