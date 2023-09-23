// O(N) O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        
        int slow = 0;
        int fast = 0;
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
// // O(NlogN) O(1)
// class Solution {
//     public int findDuplicate(int[] nums) {
//         int n = nums.length-1;
//         int low = 1;
//         int high = n;
        
//         while (low < high) {
//             int mid = low + (high-low)/2;
            
//             int c = 0;
//             for (int num: nums) {
//                 if (num <= mid) c++;
//             }
            
//             if (c > mid) {
//                 high = mid;
//             }
//             else {
//                 low = mid + 1;
//             }
//         }
//         return low;
//     }
// }