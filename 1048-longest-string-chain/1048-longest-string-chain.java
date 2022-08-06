class Solution {
    // O(NlogN + N) O(N)
    // optimized -- Map to lookup a string 
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String word: words) {
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder current = new StringBuilder(word);
                String previous = current.deleteCharAt(i).toString();
                if (map.containsKey(previous)) {
                    map.put(word, Math.max(map.get(word), map.get(previous) + 1));
                }
            }
            res = Math.max(res, map.get(word));
        }
        return res;
    }
}
// class Solution {
//     // O(NlogN + N^2) O(N) = O(N^2) O(N) 
//     Integer[] dp; 
//     String[] words;
//     int maxi = 1;
//     public int longestStrChain(String[] words) {
//         int n = words.length;
//         this.dp = new Integer[n];
//         this.words = words;
//         Arrays.sort(words, (a, b) -> a.length() - b.length());
//         for (int i = 0; i < n; i++) maxi = Math.max(maxi, chainsFrom(i));
//         return maxi;
//     }
    
//     private int chainsFrom(int index) {
//         if (index == words.length) return 0;
//         if (dp[index] != null) return dp[index];
        
//         int ans = 1;
//         for (int j = index+1; j < words.length; j++){
//             if (areChained(words[index], words[j]) == true) {
//                 ans = Math.max(ans, 1 + chainsFrom(j));
//             }
//         }
        
//         return dp[index] = ans;
//     }
    
    
//     // O(L) ~ O(16)
//     private boolean areChained(String smaller, String bigger) {
//         if (smaller.length() != bigger.length()-1) return false;
//         int i = 0;
//         int j = 0;
//         while (j < bigger.length()) {
//             if (i < smaller.length() && smaller.charAt(i) == bigger.charAt(j)) {
//                 i++; j++;
//             }
//             else {
//                 j++;
//             }
//         }
//         return i == smaller.length() && j == bigger.length();
//     }
// }