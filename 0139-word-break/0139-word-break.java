class Solution {
    /*
    O(N^2) O(N^2)
    DP
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        for (String word: wordDict) set.add(word);
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp, false);
        dp[n] = true;
        
        for (int i = n-1; i >= 0; i--) {
            String word = "";
            for (int j = i; j < n; j++) {
                word += s.charAt(j);
                if (set.contains(word)) {
                    if (dp[j+1] == true) {
                        dp[i] = true;
                        break;
                    }
                 }
            }
        }
        return dp[0];
        
    }
    /* 
    O(N^2) O(M) m = no. of words in dict
    Backtracking + Memoization
    starting from each position, if the word is present in dict,
    recurse for index + 1
    if this eventually returns false,
    try for word formed with next position
    
    */
//     Map<String, Boolean> map = new HashMap<>();
//     public boolean wordBreak(String s, List<String> wordDict) {
//         if (wordDict.contains(s)) return true;
//         if (map.containsKey(s)) return map.get(s);
        
//         for (int i = 1; i <= s.length(); i++) {
//             String left = s.substring(0, i);
//             if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
//                 map.put(s, true);
//                 return true;
//             }
//         }
//         map.put(s, false);
//         return false;
//     }
}