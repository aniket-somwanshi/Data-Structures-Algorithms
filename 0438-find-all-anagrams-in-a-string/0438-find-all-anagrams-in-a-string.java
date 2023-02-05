class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) cnt[c]++;
        
        List<Integer> ans = new ArrayList<>();
        int nChars = p.length();
        for (int r = 0, l = 0; r < s.length(); ++r) {
            char c = s.charAt(r);

            cnt[c]--;
            nChars--;
            while (cnt[c] < 0) { // If number of characters `c` is more than our expectation
                cnt[s.charAt(l)]++;  // Slide left until cnt[c] == 0
                l++;
                nChars++;
            }

            if (nChars == 0) { // If we already filled enough `p.length()` chars
                ans.add(l); // Add `l` to our result
                cnt[s.charAt(l)]++; // Go next
                l++;
                nChars++;
            }
        }
        return ans;
    }
}