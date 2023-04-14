// O(N) O(N)
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int maxiOccurrences = 0;
        Map<String, Integer> map = new HashMap<>(); // string, occurrences
        int n = s.length();
        
        for (int i = 0; i < n - minSize + 1 ; i++) {
            String subString = s.substring(i, i + minSize);
            if (isValid(subString, maxLetters)) {
                map.put(subString, map.getOrDefault(subString, 0) + 1);
                maxiOccurrences = Math.max(maxiOccurrences, map.get(subString));
            }
        }
        
        return maxiOccurrences;
    }
    
    private boolean isValid(String s, int maxLetters) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c-'a']++;
            maxLetters -= count[c-'a'] == 1 ? 1 : 0;
            if (maxLetters < 0) return false;
        }
        return true;
    }
}

// // O(N*N) O(N)
// class Solution {
//     public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
//         int maxiOccurrences = 0;
//         Map<String, Integer> map = new HashMap<>(); // string, occurrences
//         int n = s.length();
        
//         for (int i = 0; i < n; i++) {
//             for (int j = i + minSize - 1; j < Math.min(n, i + maxSize); j++) {
//                 String subString = s.substring(i, j+1);
//                 if (isValid(subString, maxLetters)) {
//                     map.put(subString, map.getOrDefault(subString, 0) + 1);
//                     maxiOccurrences = Math.max(maxiOccurrences, map.get(subString));
//                 }
//             }
//         }
        
//         return maxiOccurrences;
//     }
    
//     private boolean isValid(String s, int maxLetters) {
//         int[] count = new int[26];
//         for (char c: s.toCharArray()) {
//             count[c-'a']++;
//             maxLetters -= count[c-'a'] == 1 ? 1 : 0;
//             if (maxLetters < 0) return false;
//         }
//         return true;
//     }
// }