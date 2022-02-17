class Solution {
    // backtracking
    public List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> res = new LinkedList<>();
        //Map<Integer, boolean> map = new HashMap<>();
        List<Integer> current = new ArrayList<>();
        recur(0, current, target, a, res);
        return res;
    }
    
    private void recur(int start, List<Integer> current, int target, int[] a, List<List<Integer>> res) {
        if (target == 0) res.add(new ArrayList<>(current));
        if (target < 0) return;
        for (int i = start; i < a.length; i++) {
            current.add(a[i]);
            recur(i, current, target - a[i], a, res);
            current.remove(current.size()-1);
        }
    }
}

