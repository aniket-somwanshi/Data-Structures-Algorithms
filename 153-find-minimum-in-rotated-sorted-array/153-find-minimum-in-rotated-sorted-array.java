class Solution {
    public int findMin(int[] a) {
        if (a.length == 0) return -1;
        if (a.length == 1) return a[0];
        
        int left = 0, right = a.length-1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mid > 0 && a[mid] < a[mid-1]) return a[mid];
            else if (a[left] <= a[mid] && a[mid] > a[right]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return a[left];
    }
}