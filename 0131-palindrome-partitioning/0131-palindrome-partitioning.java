// O(2^N * N) O(N*N)
class Solution {
    Boolean[][] memo;
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        char[] a = s.toCharArray();
        int n = a.length;
        memo = new Boolean[n][n];
        f(0, n-1, a);
        
        List<List<String>> res = new ArrayList<>();
        List<String> current = new ArrayList<>();
        p(0, current, res, a);
        return res;
    }
    
    private void p(int i, List<String> current, List<List<String>> res, char[] a) {
        if (i == a.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        
        for (int j = i; j < a.length; j++) {
            if (memo[i][j]) {
                current.add(s.substring(i, j+1));
                p(j+1, current, res, a);
                current.remove(current.size()-1); // backtrack
            } 
        }
    }
    
    private boolean f(int i, int j, char[] a) {
        if (i > j) return true;
        
        if (memo[i][j] != null) return memo[i][j];
        
        boolean res = false;
        
        if (a[i] == a[j] && f(i+1, j-1, a)) res = true;
        
        f(i+1, j, a);
        f(i, j-1, a);
        
        return memo[i][j] = res;
    }
}