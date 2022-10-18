class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder res = new StringBuilder();
        String s = countAndSay(n-1);
        int count = 1;
        char current = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                count++;
            }           
            else {
                res.append(String.valueOf(count) + current);
                current = s.charAt(i);
                count = 1;
            }
        }
        res.append(String.valueOf(count) + current);
        
        return res.toString();
    }
}