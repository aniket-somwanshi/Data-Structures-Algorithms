// O(logN) O(1)
class Solution {
    public int findPeakElement(int[] a) {
        int n = a.length;
        int l = 0;
        int r = n-1;
        
        while (l <= r) {
            int m = l+(r-l)/2;
            
            boolean isLeftSmall = m-1 < 0 || a[m-1] < a[m];
            boolean isRightSmall = m+1 >= n || a[m+1] < a[m];
                            
            if (isLeftSmall && isRightSmall) return m;
            
            else if (isLeftSmall && !isRightSmall) l = m+1;
            
            else r = m-1;
        }
        
        return -1;
    }
}