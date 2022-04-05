class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] a = s.toCharArray();
        int start = 0;
        int current = 0;
        int[] occurance = new int[256];
        int maxi = 0;
        for (int i = 0; i < 256; i++) {
            occurance[i] = -1;
        }
        while (current < a.length) {
            // not a duplicate in current bounds
            if (occurance[a[current]] == -1 || occurance[a[current]] < start) {
                // mark the occurance of the element for further use
                occurance[a[current]] = current;
                // add current element to the substring
                current++;
            }
            // found a duplicate
            else {
                // calculate the length of the valid substring
                maxi = Math.max(maxi, current - start);
                // we need to remove the previous occurance of this duplicate
                // this is store in the occurance array
                // update our new start to this index + 1 we can inclued current element
                // and the prev dupicate will be discarded
                start = occurance[a[current]] + 1;
                // now we are considering only the substring [start - current]
                
                // we can now include the current element 
                // and mark it's occurance index
                occurance[a[current]] = current;
                current++;
            }
        }
        return Math.max(maxi, current - start);
    }
}