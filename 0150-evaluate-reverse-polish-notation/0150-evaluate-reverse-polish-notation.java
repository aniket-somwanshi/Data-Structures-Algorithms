class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s: tokens) {
            if (s.equals("+")) {
                // notice the chronology, num2 is second num cos if LIFO
                // this matters in divison, subtraction
                int num2 = st.pop(); 
                int num1 = st.pop(); 
                int res = num1 + num2;
                st.push(res);
            }
            else if (s.equals("-")) {
                int num2 = st.pop(); 
                int num1 = st.pop(); 
                int res = num1 - num2;
                st.push(res);
            }
            else if (s.equals("*")) {
                int num2 = st.pop(); 
                int num1 = st.pop(); 
                int res = num1 * num2;
                st.push(res);
            }
            else if (s.equals("/")) {
                int num2 = st.pop(); 
                int num1 = st.pop(); 
                int res = num1 / num2;
                st.push(res);
            }
            else { 
                int num = Integer.parseInt(s);
                st.push(num);
            }
        }
        return st.pop();
    }
}