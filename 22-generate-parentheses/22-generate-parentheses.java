class Solution {
    List<String> res; 
    int n;
    public List<String> generateParenthesis(int n) {
        this.res = new LinkedList<>();
        this.n = n;
        dfs(new StringBuilder(), 0, 0);
        return res;
    }
    
    private void dfs(StringBuilder s, int openings, int activeOpenings) {
        if (s.length() == n*2) {
            res.add(s.toString());
            return;
        }
        // check if we can add a opening bracket
        if (openings < n && activeOpenings < n) {
            s.append('(');
            dfs(s, openings+1, activeOpenings+1);
            s.deleteCharAt(s.length()-1);
        }
        
        // check if we can add a closing bracket
        if (activeOpenings > 0) {
            s.append(')');
            dfs(s, openings, activeOpenings-1);
            s.deleteCharAt(s.length()-1);
        }
    }
}