class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        char[] a = s.toCharArray();
        int start = 0;
        int end = 0;
        int maxi = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < n) {
            map.put(a[end], map.getOrDefault(a[end], 0) + 1);
            while (end - start + 1 - getFreqOfMaxCharacter(map) > k) {
                map.put(a[start], map.getOrDefault(a[start], 0) - 1);
                
                start++;
            }
            maxi = Math.max(maxi, end - start + 1);
            end++;
        }
        return maxi;
    }
    
    private int getFreqOfMaxCharacter(Map<Character, Integer> map) {
        int maxi = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            maxi = Math.max(maxi, map.getOrDefault(c, 0));
        }
        return maxi;
    } 
}