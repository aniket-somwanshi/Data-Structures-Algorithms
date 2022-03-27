class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
        int[][] defence = new int[mat.length][2];
        for(int i = 0; i < mat.length; i++) {
            int counter = 0;
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 1) {
                    counter++;
                }
            }
            defence[i][0] = i;
            defence[i][1] = counter;
        }
        
        // int[] wToS = new int[mat.length];
        for(int i = 0; i < defence.length - 1; i++) {
                int j = i + 1;
                while(j >= 1 && defence[j - 1][1] > defence[j][1]) {
                    int temp = defence[j][1];
                    defence[j][1] = defence[j - 1][1];
                    defence[j - 1][1] = temp;
                    int tempI = defence[j][0];
                    defence[j][0] = defence[j - 1][0];
                    defence[j - 1][0] = tempI;
                    j--;
                }
            // wToS[i] = defence[min][0];
        }
        
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = defence[i][0];
        }
        
        return ans;
    }

}