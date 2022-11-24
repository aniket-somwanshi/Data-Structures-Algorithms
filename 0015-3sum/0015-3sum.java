class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);
        
        
        for (int i = 0; i < n; i++) {
            // do not repeat a triplet value that is already considered
            if (i > 0 && a[i] == a[i-1]) continue;
            
            int target = -a[i];
            
            // find pair that sums to target
            int j = i+1;
            int k = n-1;
            
            while (j < k) {
                if (a[j] + a[k] == target) {
                    res.add(new ArrayList<>(Arrays.asList(a[i], a[j], a[k])));
                    j++;
                    while (j < k && a[j] == a[j-1]) j++;
                    k--;
                    while (k > j && a[k] == a[k+1]) k--;
                }
                else if (a[j] + a[k] > target) {
                    k--;
                    while (k > j && a[k] == a[k+1]) k--;
                }
                else {
                    j++;
                    while (j < k && a[j] == a[j-1]) j++;
                }
            } 
        }
        
        return res;
    }
}