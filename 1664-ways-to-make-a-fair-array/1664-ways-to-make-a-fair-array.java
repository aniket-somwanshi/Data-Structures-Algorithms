// O(2N) O(N) -- can be made O(N) O(1)
class Solution {
    public int waysToMakeFair(int[] a) {
        int n = a.length;
        
        int[] oes = new int[n];
        int[] oos = new int[n];
        
        for (int i = n-1; i >= 0; i--) {
            if (i % 2 == 0) {
                oes[i] = (i+1>=n?0:oes[i+1]) + a[i];
                oos[i] = (i+1>=n?0:oos[i+1]);
            }
            else {
                oos[i] = (i+1>=n?0:oos[i+1]) + a[i];
                oes[i] = (i+1>=n?0:oes[i+1]);
            }
        }
        
        int tes = oes[0];
        int tos = oos[0];

        int count = 0;

        for (int i = n-1; i >= 0; i--) {
            if (i % 2 == 1) {
                int nes = tes - oes[i] + oos[i] - a[i];
                int nos = tos - oos[i] + oes[i];
                count += nes == nos ? 1 : 0;
            }   
            else {
                int nes = tes - oes[i] + oos[i];
                int nos = tos - oos[i] + oes[i] - a[i];
                count += nes == nos ? 1 : 0;
            }
        }

        return count;
    }
    
    
}