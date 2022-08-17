class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        String[] moors = 
        {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for (String word: words) {
            StringBuilder moorsCode = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                moorsCode.append(moors[word.charAt(i)-'a']);
            }
            set.add(moorsCode.toString());
        }
        
        return set.size();

    }
}