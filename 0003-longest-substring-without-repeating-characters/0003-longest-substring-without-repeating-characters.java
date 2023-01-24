class Solution {
    // O(N) O(N) -- 2 pointer
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        char[] a = s.toCharArray();
        if (s == null || s.length() == 0) return 0;
        int maxi = 1;
        Map<Character, Integer> map = new HashMap<>();
        while (end < n) {
            if (map.containsKey(a[end]) && map.get(a[end]) >= start) {
                start = map.get(a[end]) + 1;
            }
            map.put(a[end], end);
            maxi = Math.max(maxi, end - start + 1);
            end++;
        }
        
        return maxi;
    }
}