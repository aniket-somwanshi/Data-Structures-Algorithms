// O()
class Solution {
    public int uniquePaths(int M, int N) {
        int n = M; 
        int m = N;
        int[] up = new int[m];
        Arrays.fill(up, 1);
        
        for (int i = 1; i < n; i++) {
            int[] current = new int[m];
            for (int j = 0; j < m; j++) {
                if (j == 0) current[j] = 1;
                else current[j] = up[j] + current[j-1];
            }
            up = current;
        }
        return up[m-1];
    }
}