class Solution {
    Map<Integer, List<String>> memo;
    Set<String> set;
    String s;
    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        this.s = s;
        this.set = new HashSet<>();
        for (String str: wordDict) {
            set.add(str);
        }
        return f(0);
    }
    
    private List<String> f(int index) {  
        if (index == s.length()) return new ArrayList<>();
        
        if (memo.containsKey(index)) return memo.get(index);
        
        List<String> currentRes = new ArrayList<>();
        
        for (int i = index; i < s.length(); i++) {
            String candidate = s.substring(index, i+1);
            if (set.contains(candidate)) {
                List<String> rest = f(i+1);
                if (!rest.isEmpty()) {
                    for (String restPartition: rest) {
                        currentRes.add(candidate + " " + restPartition);
                    }
                }
                else if (i+1 == s.length()) {
                    currentRes.add(candidate);
                }
            }
        }
        
        memo.put(index, currentRes);
        return currentRes;
    }
}