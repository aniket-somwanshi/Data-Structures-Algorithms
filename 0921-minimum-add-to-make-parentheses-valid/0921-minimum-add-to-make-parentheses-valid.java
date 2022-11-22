class Solution {
    public int minAddToMakeValid(String s) {
        int stillOpen = 0;
        int closingFails = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stillOpen++;
            }
            else if (stillOpen > 0){
                stillOpen--;
            }
            else {
                closingFails++;
            }
        }
        return stillOpen + closingFails;
    }
}