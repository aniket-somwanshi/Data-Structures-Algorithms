class Solution {
    // O(logN) O(1)
    // at the index `mid`, the countOfMissingNumbers = mid - (a[mid]+1) 
    // if it's <= k, we need more missingNumbers, so go right
    // else go left
    // at the end the right goes before left
    // at this point, we know our target number lies betn right to a[right]
    // and we know at this point, what's the countOfMissingNumbers
    // we may need some more so as to get to k
    // so required number is a[right] + (remaining)
    // = a[right] + (k - countOfMissingNumbers)
    public int findKthPositive(int[] a, int k) {
        // if the kth element is even behind a[0]
        // then return kth number directly
        //if (k < a[0]) return k;
        
        int n = a.length;
        int left = 0;
        int right = n-1;
        int countOfMissingNumbersAtThisPoint = a[n-1] - n;
        while (left <= right) {
            int mid = left + (right - left)/2;
            
             countOfMissingNumbersAtThisPoint = a[mid] - (mid + 1);
            if (countOfMissingNumbersAtThisPoint >= k) {
                right = mid-1;
            }
            else left = mid + 1;
        }
        if (right == -1) return k;
        return a[right] + k - (a[right] - (right + 1));
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