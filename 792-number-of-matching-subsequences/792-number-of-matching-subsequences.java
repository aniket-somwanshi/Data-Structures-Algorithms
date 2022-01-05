class Solution {
    /*
    O(words.length * maxlen(words[i]) + s.length)
    for s, store index of each character
    s = "abb"
    a -> [0]
    b -> [1, 2]
    for each word
    for each letter check if this letter is present in hashmap
    and if it's index is greater than last used index
    if any letter from word is not found, it's not a subsequence of s
    */
    public int numMatchingSubseq(String s, String[] words) {
        // preprocess s
        // create hashmap
        Map<Character, List<Integer>> map = new HashMap<>(); // character -> occurrance indices
        // initialize map. All characters with empty list
        for (char character = 'a'; character <= 'z'; character++) {
            map.put(character, new LinkedList<>());
        }
        // fill the map
        for (int i = 0; i < s.length(); i++) {
            map.get(s.charAt(i)).add(i);
        }
        
        // check for every word
        int count = 0;
        for (String word: words) {
            if (isSubsequence(word, s, map)) count++;
        }
        
        return count;
    }
    
    private boolean isSubsequence(String word, String s, Map<Character, List<Integer>> map) {
        int lastUsedIndexFromS = -1;
        for (int i = 0; i < word.length(); i++) {
            char target = word.charAt(i);
            // check if map contains a valid occurance of this character
            boolean foundTarget = false;
            for (int index: map.get(target)) {
                if (index > lastUsedIndexFromS) {
                    // use this
                    lastUsedIndexFromS = index;
                    foundTarget = true;
                    break;
                }
            }
            if (foundTarget == false) return false;
        }
        return true;
    }
    
    // O(s.length * words.length * maxlen(words[i])) O(1)
    // Brute TLE
//     public int numMatchingSubseq(String s, String[] words) {
//         int count = 0;
//         for (String word: words) {
//             if (isSubsequence(word, s)) count++;
//         }
//         return count;
//     }
    
//     private boolean isSubsequence(String word, String s) {
//         int i = 0;
//         int j = 0;
//         while (i < word.length()) {
//             while (j < s.length() && s.charAt(j) != word.charAt(i)) {
//                 j++;
//             }
//             if (j == s.length()) return false;
//             j++;
//             i++;
//         }
//         return i == word.length();
//     }
}