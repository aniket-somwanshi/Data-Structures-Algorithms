class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        
        for (String q: queries) {
            for (String d: dictionary) {
                if (compareTo(q, d) <= 2) {
                    res.add(q);
                    break;
                }
            }
        }
        return res;
    }
    
    private int compareTo(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return diff;
    } 
}