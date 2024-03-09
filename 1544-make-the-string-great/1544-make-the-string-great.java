class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(c);
            }
            else {
                char prev = st.peek();
                if (Math.abs(prev - c) == Math.abs('a'-'A')) {
                    st.pop();
                }
                else {
                    st.push(c);
                }
            }
        }
        
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}