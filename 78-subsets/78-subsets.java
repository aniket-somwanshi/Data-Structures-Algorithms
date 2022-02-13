class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recur(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void recur(int[] nums, int i, List<Integer> current, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList(current));
            return;
        }
        // handle duplicates
        if (i != 0 && nums[i] == nums[i-1]) {
            recur(nums, i+1, current, res);
        }
        else {
            // either select or not select 
            // select
            current.add(nums[i]);
            recur(nums, i+1, current, res);
            // not select
            current.remove(current.size()-1);
            recur(nums, i+1, current, res);
        }
        
    }
}



// class Solution {
//   List<List<Integer>> output = new ArrayList();
//   int n, k;

//   public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
//     // if the combination is done
//     if (curr.size() == k)
//       output.add(new ArrayList(curr));

//     for (int i = first; i < n; ++i) {
//       // add i into the current combination
//       curr.add(nums[i]);
//       // use next integers to complete the combination
//       backtrack(i + 1, curr, nums);
//       // backtrack
//       curr.remove(curr.size() - 1);
//     }
//   }

//   public List<List<Integer>> subsets(int[] nums) {
//     n = nums.length;
//     for (k = 0; k < n + 1; ++k) {
//       backtrack(0, new ArrayList<Integer>(), nums);
//     }
//     return output;
//   }
// }