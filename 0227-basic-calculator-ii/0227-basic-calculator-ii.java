class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();        
        
        char previousSign = '+';
        int i = 0;
        while (i < s.length()) {
            int currentNumber = 0;
            if (Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    currentNumber = currentNumber * 10 + s.charAt(i)-'0';
                    i++;
                }
                i--;
                // we have the number now
                // we check the previously encountered sign wa
                // if it was * or / we can just do that operation between prev result and currentNumber, and then push result to stack
                // if it was + or - we need to delay the operation so just put current number in stack
                // if it's a + we add +currentNumber in the stack and for - we add -currentNumber in stack
                if (previousSign == '+') st.push(+currentNumber);
                else if (previousSign == '-') st.push(-currentNumber);
                else if (previousSign == '*') st.push(st.pop() * currentNumber);
                else if (previousSign == '/') st.push(st.pop() / currentNumber);                
                
            }
            // update the previousSign for the next iteration
            else if (s.charAt(i) != ' ') {
                // it's a sign
                previousSign = s.charAt(i);
            }
            i++;
        }
        
        int res = 0;
        while (!st.isEmpty()) res += st.pop();
        return res;
    }
}