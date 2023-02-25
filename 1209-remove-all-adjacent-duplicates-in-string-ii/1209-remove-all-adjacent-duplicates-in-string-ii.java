// O(N) O(N)
class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> st = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (!st.isEmpty() && st.peek().c == c) {
                st.peek().f++;
            }
            else st.push(new Pair(c, 1));
            
            // remove k equal chars from the top
            if (st.peek().f >= k) {
                st.peek().f -= k;
                if (st.peek().f == 0) st.pop(); 
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            for (int i = 0; i < st.peek().f; i++) {
                sb.append(st.peek().c);
            }
            st.pop();
        }
        return sb.reverse().toString();
    }
}
class Pair{
    char c;
    int f;
    public Pair(char c, int f) {
        this.c = c;
        this.f = f;
    }
}