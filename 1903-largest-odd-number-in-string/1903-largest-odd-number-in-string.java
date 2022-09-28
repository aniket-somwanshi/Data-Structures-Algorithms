class Solution {
    // O(N) O(1)
    public String largestOddNumber(String num) {
        int n = num.length();
        int i = n - 1;
        for (; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}