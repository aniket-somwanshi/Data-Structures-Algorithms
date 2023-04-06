class Solution {
    // O(N*M), O(26*M)
    // N = no. of strings
    // M = average length of each string
    // create frequency list of each string and if same, group them
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String s: strs) {
            Map<Character, Integer> freq_map = new HashMap<>();
            for (char c: s.toCharArray()) {
                if (!freq_map.containsKey(c)) freq_map.put(c, 0);
                freq_map.put(c, freq_map.getOrDefault(c, 0) + 1);
            }
            if (!map.containsKey(freq_map)) {
                map.put(freq_map, new ArrayList<>());
            }
            map.get(freq_map).add(s);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (List<String> val: map.values()) {
            res.add(val);
        }
        return res;
    }
}
/*
"eat","tea","tan","ate","nat","bat"
"aet","aet","ant","aet","ant","abt"
*/