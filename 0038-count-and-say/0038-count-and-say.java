class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        return say(countAndSay(n-1));
    }
    
    private String say(String input) {
        String res = "";
        int i = 0;
        while (i < input.length()) {
            // reset counts
            char currentNumber = input.charAt(i);
            int currentNumberCount = 0;
            // find cout of current character
            while (i < input.length() && input.charAt(i) == currentNumber) {
                currentNumberCount++;
                i++;
            }
            res += Integer.toString(currentNumberCount) + currentNumber;
        }
        return res;
    }
}