class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        f(current, res, nums);
        return res;
    }
    
    private void f(List<Integer> current, List<List<Integer>> res, int[] nums) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        
        for (int num: nums) {
            if (!current.contains(num)) {
                current.add(num);
                f(current, res, nums);
                current.remove(current.size()-1);
            }
        }
    }
}