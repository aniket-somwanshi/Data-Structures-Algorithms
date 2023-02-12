// O(log(M+N)) O(1)
class Solution {
    public double findMedianSortedArrays(int[] a1, int[] a2) {
        int n = a1.length;
        int m = a2.length;
        
        if (m < n) return findMedianSortedArrays(a2, a1);
        
//         if (n == 0) return m%2 == 1 ? (double)a2[(m/2)] : (double)(a2[m/2] + a2[(m/2)-1]) / 2.0;
//         if (m == 0) return n%2 == 1 ? (double)a1[(n/2)] : (double)(a1[n/2] + a1[(n/2)-1]) / 2.0;
        
        // try to take 'k' elements from a1
        
        // l1 -> end index of a1 in left
        // l2 -> end index of a2 in left
        // r1 -> start index of a1 in right
        // r2 -> start index of a2 in right
        int low = 0;
        int high = n;
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            
            int k1 = mid;
            int k2 = (n+m+1)/2 - k1;
            
            int l1 = k1 == 0 ? Integer.MIN_VALUE : a1[k1-1];
            int l2 = k2 == 0 ? Integer.MIN_VALUE : a2[k2-1];
            
            int r1 = k1 == n ? Integer.MAX_VALUE : a1[k1];
            int r2 = k2 == m ? Integer.MAX_VALUE : a2[k2];
            
            // check to see if it's valid or left heavy or right heavy
            // We know that a1[l1] should be <= a2[r2]
            // So if it's not, it means a1's l1 holds bigger elements than required
            // how to make l1 have smaller element? 
            // we know l1 means last el of a1 taken. And the array is sorted
            // so reduce the number of el taken from a1
            // ie reduce k, ie mid
            if (l1 > r2) {
                high = mid-1;
            }
            else if (l2 > r1) {
                // the opposite case where a2 has too many big elements, 
                // so decrease it by increasing k ie mid
                low = mid+1;
            }
            else {
                // this means it's a valid partition, so we found the median elements
                // return the median based on odd or even lengths
                if ((m+n)%2==1) {
                    // odd
                    return (double)Math.max(l1, l2); 
                }
                else {
                    // even
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0; 
                }
            }
        } 
        return 0.0;
    }
}