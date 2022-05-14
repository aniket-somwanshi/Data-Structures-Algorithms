class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        if (s.length() <= 2) return s;
        res.append(s.charAt(0));
        res.append(s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1) || s.charAt(i) != s.charAt(i-2)) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}