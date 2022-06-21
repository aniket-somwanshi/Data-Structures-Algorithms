class Solution {
    public int search(int[] a, int target) {
        int left = 0, right = a.length-1;
        int mid;
        while (left <= right) {
            mid = left +(right - left)/2;
            
            if (a[mid] == target) return mid;
            // if both halves are sorted, ie whole array is sorted, apply binary Search
            else if (a[left] <= a[mid] && a[mid] <= a[right]) { 
                return binarySearch(a, left, right, target);
            }
            // if left half is sorted
            else if (a[left] <= a[mid]) {
                // if target lies in this half
                if (a[left] <= target && target <= a[mid]) {
                    // binary search to find this exisitng element
                    return binarySearch(a, left, mid, target);
                }
                else {
                    // it can be on the righ half, which is not sorted
                    // so again try this approch on right half
                    left = mid + 1;
                }
            }
            // similarly do for right half
            // righ half is sorted
            else if (a[mid] <= a[right]) {
                // if target lies in this sorted half
                if (a[mid] <= target && target <= a[right]) {
                    // binary search to find this exisitng element
                    return binarySearch(a, mid, right, target);
                }
                else {
                    // it can be on the left half, which is not sorted
                    // so again try this approch on left half
                    right = mid - 1;
                }
            }
            else {
                   
            }
        }
        
        return -1;
    
    }
    
    int binarySearch(int[] a, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = left + (right - left)/2;
            if (a[mid] == target) return mid;
            else if (a[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    } 
    
    
}