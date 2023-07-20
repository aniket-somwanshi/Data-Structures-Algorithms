class Solution {
    public double findMedianSortedArrays(int[] a1, int[] a2) {
        int n = a1.length;
        int m = a2.length;
        
        if (m < n) return findMedianSortedArrays(a2, a1);
        int low = 0;
        int high = Math.min(n, (m+n+1)/2);
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            
            int k1 = mid;
            int k2 = (n+m+1)/2 - k1;
            
            int l1 = k1 == 0 ? Integer.MIN_VALUE : a1[k1-1];
            int l2 = k2 == 0 ? Integer.MIN_VALUE : a2[k2-1];
            
            int r1 = k1 == n ? Integer.MAX_VALUE : a1[k1];
            int r2 = k2 == m ? Integer.MAX_VALUE : a2[k2];
            
            
            if (l1 <= r2 && l2 <= r1) {
                // return ans
                if ((n+m) % 2 == 1) {
                    System.out.println(mid);
                    // System.out.println(a2[l2]);
                    
                    // biggest in the left half
                    return Math.max(l1, l2); 
                }
                else {
                    int candidate1 =  Math.max(l1, l2);
                    int candidate2 = Math.min(r1, r2);
                    return (candidate1 + candidate2)/2.00;
                }
            }
            else if (l1 > r2) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
}