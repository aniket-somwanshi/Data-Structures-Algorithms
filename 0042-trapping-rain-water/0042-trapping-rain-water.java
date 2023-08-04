class Solution {
    public int trap(int[] a) { 
        int n = a.length;
        int i = 0; // left
        int j = n-1; // right
        int cmh = 0; // currentMaxHeight
        int ca = 0; // currentArea
        
        while (i < j) {
            int potentialNewHeight = Math.min(a[i], a[j]);
            int extraHeight = 0;
            if (potentialNewHeight > cmh) {
                extraHeight = potentialNewHeight - cmh;
                cmh = potentialNewHeight;
            }
            ca += extraHeight * (j-i-1);
            
            if (a[i] <= a[j]) {
                 i++;
                if (i >= j) break;
                ca -= Math.min(a[i], cmh);
            } 
            else {
                j--;
                if (i >= j) break;
                ca -= Math.min(a[j], cmh);
            }
        }
        
        return ca;
    }
}