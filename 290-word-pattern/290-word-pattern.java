class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> dic = new HashMap<Character, String>(); // the projection map, key is the char in pattern and the value is a word
        Set<String> word_set = new HashSet<String>();;
        Set<Character> pattern_set = new HashSet<Character>();
        String[] words = s.split(" ");
        for (String word: words) word_set.add(word);
        for (char c: pattern.toCharArray()) pattern_set.add(c);
		// 'aa' -> 'dog', 'ab' -> 'dog dog', 'abc'- > 'cat dog cat'
        if (words.length != pattern.length() || word_set.size() != pattern_set.size()) return false;
        for (int i = 0; i < words.length; i++) {
            if (dic.containsKey(pattern.charAt(i))) { // pattern[i] has been projected to some word
                if (!dic.get(pattern.charAt(i)).equals(words[i])) return false; // 'aba' -> 'cat dog dog'
            } else {
                dic.put(pattern.charAt(i), words[i]);
            }
        }
        return true;   
    }
}