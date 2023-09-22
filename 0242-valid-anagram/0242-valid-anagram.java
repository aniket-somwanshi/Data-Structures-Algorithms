// O(N+M) O(N)
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (Character c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for (Character c: t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            int count = map.get(c);
            if (count == 1) map.remove(c);
            else map.put(c, count-1); //reduce freq by one
        } 
        
        return map.size()==0;
    }
    
}