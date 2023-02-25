// O()
class Solution {
    public int longestSubsequence(int[] a, int difference) {
        int n = a.length;
        
        int maxiLen = 1;
        Map<Integer, Integer> map = new HashMap<>(); // number->maxLenSeq
        
        for (int i = n-1; i >= 0; i--) {
            int maxiLenStartingHere = 1;
            if (map.containsKey(a[i] + difference)) {
                maxiLenStartingHere = map.get(a[i] + difference) + 1;
            } 
            else {
                // it's answer is 1 so no need to update maxLen   
            }
            map.put(a[i], maxiLenStartingHere);
            maxiLen = Math.max(maxiLen, maxiLenStartingHere);
        }
        
        return maxiLen;
    }
}