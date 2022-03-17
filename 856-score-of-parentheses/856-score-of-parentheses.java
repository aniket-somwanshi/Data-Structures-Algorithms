class Solution {
    // O(N^2) O(N)
    public int scoreOfParentheses(String s) {
        int i = 0;
        return getScoreOf(s, 0);
    }
    
    private int getScoreOf(String s, int i) {
        System.out.println(s);
        int score = 0;
        if (s.length() < 2) return 0;
        
        while (i < s.length()) {
            // case 1: () 
            if (s.charAt(i) == '(' && s.charAt(i+1) == ')') {
                score++;
                i+=2;
            }
            else if (s.charAt(i) == '(' && s.charAt(i+1) == '(') {
                int state = 0;
                i++;
                int start = i;
                while (state != -1) {
                    // update state
                    state += s.charAt(i) == '(' ? 1 : -1;
                    i++;
                }
                score += 2*getScoreOf(s.substring(start, i-1), 0);
            }
        }
        return score;
    }
}