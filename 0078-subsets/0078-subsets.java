class Solution {
    int[] a;
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        a = nums;
        List<Integer> current = new ArrayList<>();
        getAllSubsets(0, current, res);
        return res;
    }
    
    private void getAllSubsets(int index, List<Integer> current, List<List<Integer>> res) {        
        if (index == a.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        
        // choose and not choose
        getAllSubsets(index+1, current, res);
        
        current.add(a[index]);
        getAllSubsets(index+1, current, res);
        current.remove(current.size()-1);
    }
}

// class Solution {
//     int[] a;
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         a = nums;
//         List<Integer> current = new ArrayList<>();
//         getAllSubsets(0, current, res);
//         return res;
//     }
    
//     private void getAllSubsets(int index, List<Integer> current, List<List<Integer>> res) {        
//         res.add(new ArrayList<>(current));
        
//         if (index == a.length) return;
        
//         for (int i = index; i < a.length; i++) {
//             current.add(a[i]);
//             getAllSubsets(i+1, current, res);
//             current.remove(current.size()-1);
//         }
//     }
// }