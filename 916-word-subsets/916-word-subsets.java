class Solution {
    // N = words1.length
    // M = words2.length
    // O(M * maxLen(M) + N * maxLen(N) + N*26)
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length;
        int m = words2.length;
        List<String> res = new LinkedList<>();
        
        // create the expected freq map using words2
        Map<Character, Integer> expectedFreq = new HashMap<>();
        // initialize with all zeroes
        for (int i = 'a'; i <= 'z'; i++) {
            expectedFreq.put((char)i, 0);
        }
        
        for (String word: words2) {
            Map<Character, Integer> currentMap = new HashMap<>();
            for (char c: word.toCharArray()) {
                int currentFreq = currentMap.containsKey(c) ? currentMap.get(c) + 1 : 1;
                currentMap.put(c, currentFreq); // update
                // if this freq is greater than that in expectedFreq map, update it
                if (currentFreq > expectedFreq.get(c)) expectedFreq.put(c, currentFreq);
            }
        }
       
        
        // for each word words1 check if a char's freq is 
        // >= that in expected freq 
        for (String word: words1) {
            // create Map
            Map<Character, Integer> map = new HashMap<>();
            for (char c: word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
//             System.out.println(word);
//              map.entrySet().forEach(entry -> {
//     System.out.println(entry.getKey() + " " + entry.getValue());
// });
            // for each lowercase letter, freq in map needs to suffice that in expected map
            boolean flag = true;
            for (int i = 'a'; i <= 'z'; i++) {
                char c = (char)i;
                if (expectedFreq.get(c) > 0 && (map.containsKey(c) == false || map.get(c) < expectedFreq.get(c))) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(word);
        }
        
        return res;
    }
}