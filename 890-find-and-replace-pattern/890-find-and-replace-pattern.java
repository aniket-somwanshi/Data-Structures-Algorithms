class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n = pattern.length();
        List<String> res = new LinkedList<>();
        
        // find identity array for pattern
        int[] identityOfPattern = getIdentity(pattern);
        System.out.println(Arrays.toString(identityOfPattern));
        // for every word, check if its identity array matches with pattern's identity array
        for (String word: words) {
            System.out.println(Arrays.toString(getIdentity(word)));
            if (Arrays.equals(getIdentity(word), identityOfPattern)) {
                
                res.add(word);
            }
        }
        
        return res;
    }
    
    private int[] getIdentity(String word) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();
        int[] identity = new int[n];
        Arrays.fill(identity, -1);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(word.charAt(i))) {
                identity[i] = map.get(word.charAt(i));
                // update the recent position of this char
                map.put(word.charAt(i), i);
            }
            else {
                map.put(word.charAt(i), i);
            }
        }
        return identity;
    }
}