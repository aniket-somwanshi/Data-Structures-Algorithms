class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        f(new ArrayList<>(), 1, n, res, k);
        return res;
    }
    
    private void f(List<Integer> c, int index, int sum, List<List<Integer>> res, int n) {
        if (sum == 0 && c.size() == n) {
            res.add(new ArrayList<>(c));
            return;
        }
        if (sum < 0 || c.size() > n || index > 9) return;
        
        for (int i = index; i <= 9; i++) {
            c.add(i);
            f(c, i+1, sum-i, res, n);
            c.remove(c.size()-1);
        }
    }
}