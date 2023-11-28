// O(N) O(1)
class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxi = 0;
        int noOfVowels = 0;
        
        while (right < n) {
            noOfVowels += set.contains(s.charAt(right)) ? 1 : 0;
            
            if (right - left + 1 > k) {
                noOfVowels -= set.contains(s.charAt(left++)) ? 1 : 0;
            }
            
            if (right - left + 1 == k) {
                maxi = Math.max(maxi, noOfVowels);
            }
            
            right++;
        }
        
        return maxi;
    }
}