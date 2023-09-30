// O(NlogN) O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>(); // increasing subsequence
        int maxi = 1;
        for (int num: nums) {
            if (sub.isEmpty() || sub.get(sub.size()-1) < num) {
                sub.add(num);
            }
            else {
                replaceWithFirstElementGreaterThan(num, sub);
            }
            maxi = Math.max(maxi, sub.size());
        }
        return maxi;
    }
    
    private void replaceWithFirstElementGreaterThan(int num, List<Integer> sub) {
        // binary search to find the smallest element greater than num
        int left = 0;
        int right = sub.size()-1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (sub.get(mid) >= num) {
                res = mid;
                right = mid-1;
            }
            else {
                left = mid + 1;
            }
        }
        
        sub.set(res, num);
    }
}