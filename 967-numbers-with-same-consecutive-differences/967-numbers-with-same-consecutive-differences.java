class Solution {
    List<List<Integer>> nextDigit;
    // O(2^N) O(N + 10)
    public int[] numsSameConsecDiff(int n, int k) {
        nextDigit = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i <= 9; i++) {
            nextDigit.add(new ArrayList<>());
        }
        
        for (int i = 0; i <= 9; i++) {
            if (k == 0) {
                nextDigit.get(i).add(i);
                continue;
            }
            if (isValid(i + k)) nextDigit.get(i).add(i + k);
            if (isValid(i - k)) nextDigit.get(i).add(i - k);
        }
        
        for (int i = 1; i <= 9; i++) {
            dfs(i, 0, n-1, res);
        } 
        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
    
    private void dfs(int currentDigit, int currentNumber, int n, List<Integer> res) {
        currentNumber = currentNumber*10 + currentDigit;
        if (n == 0) {
            res.add(currentNumber);
            return;
        }
        
        for (int next: nextDigit.get(currentDigit)) {
            dfs(next, currentNumber, n-1, res);
        }
    }
    
    private boolean isValid(int digit) {
        if (digit < 0 || digit > 9) return false;
        return true;
    }
}