class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String bannedWord: banned) {
            set.add(bannedWord);
        }
        
        char[] a = paragraph.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        
        int i = 0;
        while (i < a.length) {
            StringBuilder s = new StringBuilder();
            while (i < a.length && isSymbol(a[i]) == false) {
                s.append(a[i]);
                i++;
            }
            // this is a word. update it's freq
            String word = s.toString().toLowerCase();
            // if this word is banned, we have no business with it
            if (set.contains(word) == false) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            } 
            
            // skip symbols in between so as to get to the next word
            while (i < a.length && isSymbol(a[i]) == true) {
                i++;
            }
        }
        
        // map contains freq of unbanned words. return the maxfreq word
        String res = "";
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
    
    private boolean isSymbol(char c) {
        if (c == ' ' || c == '!' || c == '?' || c == ',' || c == ';' || c == '.' || c == '\'') return true;
        return false;
    }
}