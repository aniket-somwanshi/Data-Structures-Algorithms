// O(N) O(1)
class Solution {
    public long countVowels(String word) {
        long res = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        for (int i = 0; i < word.length(); i++) {
            if (!vowels.contains(word.charAt(i))) continue;
            long before = i + 1;
            long after = word.length() - i;
            
            res += before * after;
        }
        
        return res;
    }
}