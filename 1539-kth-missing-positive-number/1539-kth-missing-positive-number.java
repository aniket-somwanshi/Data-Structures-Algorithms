class Solution {
    public int findKthPositive(int[] a, int k) {
        int left = 0;
        int right = a.length-1;
        int res = -1;
        if (k < a[0]) return k;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (a[mid] <= k + mid) {
                res = k + (mid+1);
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }    
        }
        return res;
    }
}


// class Solution {
//     // O(N) O(1)
//     public int findKthPositive(int[] arr, int k) {
//         int currentKthMissingInteger = k;
//         for (int num: arr) {
//             if (num <= currentKthMissingInteger) {
//                 currentKthMissingInteger ++;
//             }
//             else return currentKthMissingInteger;
//         }
//         return currentKthMissingInteger;
//     }
// }