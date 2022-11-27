// O(N) O(1) 
// a high product can be obtained by
// 1. multiplying a high +ve no by a +ve no
// 2. multiplying a high -ve no by a -ve no
// so keep running max and mins
// and try multiplying them with current el 
// to get a possibly best product
class Solution {
    public int maxProduct(int[] a) {
        int miniCurrent = a[0];
        int maxiCurrent = a[0];
        
        int res = a[0];
        
        for (int i = 1; i < a.length; i++) {
            int maxiCurrentOG = maxiCurrent;
            int miniCurrentOG = miniCurrent;
            
            maxiCurrent = Math.max(a[i], Math.max(maxiCurrentOG * a[i], miniCurrentOG * a[i]));
            
            miniCurrent = Math.min(a[i], Math.min(maxiCurrentOG * a[i], miniCurrentOG * a[i]));
            
            res = Math.max(res, maxiCurrent);
        }
        
        return res;
    }
}