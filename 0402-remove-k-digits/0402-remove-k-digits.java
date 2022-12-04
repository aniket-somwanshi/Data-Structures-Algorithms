class Solution {
    // O(N) O(N) -- monotonic stack
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> s = new Stack<Character>();
        for (char c: num.toCharArray()) {
            if (k == 0) {
                s.push(c);
                continue;
            }
            while (k > 0 && !s.isEmpty() && s.peek() > c) {
                s.pop();
                k--;
            }
            s.push(c);
        }
        String res = "";
        while(!s.isEmpty()) res += s.pop();
        // if k is still left
        res = res.substring(k);
        StringBuilder sb = new StringBuilder(res);
        res = sb.reverse().toString();
        return removeLeadingZeros(res);
    }
    
    private String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i) == "" ? "0": s.substring(i);
    }
}