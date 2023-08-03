class Solution {
    int n;
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this.n = n;
        f("", 0, 0);
        return res;
    }
    
    private void f(String current, int open, int close) {
        if (current.length() == n*2) {
            res.add(current);
            return;
        }
        
        if (open < n) {
            f(current + '(', open+1, close);
        }
        if (open > close) {
            f(current + ')', open, close+1);
        }
    }
}