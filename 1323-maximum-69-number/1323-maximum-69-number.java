// O(3N) O(3N) N = number of digits in num
class Solution {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        String res = "";
        boolean done = false;
        for (char c: s.toCharArray()) {
            if (c == '6' && !done) {
                res += '9';
                done = true;
            }
            else res += c;
        }
        return Integer.parseInt(res);
    }
}