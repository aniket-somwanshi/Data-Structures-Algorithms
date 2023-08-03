class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int target = -nums[i];
            int j = i+1;
            int k = n-1;
            
            while (j < k) {
                int sum = nums[j] + nums[k];
                
                if (sum < target) {
                    j++;
                }
                else if (sum > target) {
                    k--;
                }  
                else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(triplet);
                    // skip duplicates
                    while (j < k && nums[j] == triplet.get(1)) {
                        j++;
                    }
                    while (k > j && nums[k] == triplet.get(2)) {
                        k--;
                    }
                }
            }
            i++;
            while (i < n && nums[i] == nums[i-1]) i++;
        }
        
        return res;
    }
}