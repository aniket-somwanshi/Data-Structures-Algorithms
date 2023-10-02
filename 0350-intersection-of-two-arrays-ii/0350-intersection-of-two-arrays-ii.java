// O(N+N) O(N)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        int[] freq1 = new int[1001];
        int[] freq2 = new int[1001];
        
        for (int num: nums1) {
            freq1[num]++;
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int num: nums2) {
            freq2[num]++;
            if (freq2[num] <= freq1[num]) {
                res.add(num);
            }
        }
        
        int[] r = new int[res.size()];
        int i = 0;
        for (int num: res) r[i++] = num;
        return r;
    }
}