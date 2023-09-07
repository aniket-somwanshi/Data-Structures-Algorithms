class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int base = 1;
        for (int i = columnTitle.length()-1; i >= 0; i--) {
            int num = columnTitle.charAt(i)-'A' + 1;
            res += base * num;
            base = base * 26;
        }
        return res;
    }
}