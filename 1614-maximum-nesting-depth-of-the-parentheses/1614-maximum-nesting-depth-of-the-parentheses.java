class Solution {
    // O(N) O(1)
    public int maxDepth(String s) {
        int power = 0;
        int res = 0;
        for (Character c: s.toCharArray()) {
            if (c == '(') {
                power++;
                res = Math.max(res, power);
            }
            else if (c == ')') power--;
        }
        return res;
    }
}