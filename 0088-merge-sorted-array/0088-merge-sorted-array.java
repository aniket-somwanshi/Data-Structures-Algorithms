// O(N+M) O(1) 
// there are extra sapces present at the end of a1
// so start filling largest element at a1[k] starting from behind
// finally if elements are left from a2 copy them over at the start of a1
class Solution {
    public void merge(int[] nums1, int n, int[] nums2, int m) {
        int k = nums1.length-1;
        int i = n-1;
        int j = m-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j];
                j--;
            }  
            else if (nums2[j] < nums1[i]) {
                nums1[k--] = nums1[i];
                i--;
            }
            else {
                nums1[k--] = nums1[i];
                i--;
            }
        }
        
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
    
}