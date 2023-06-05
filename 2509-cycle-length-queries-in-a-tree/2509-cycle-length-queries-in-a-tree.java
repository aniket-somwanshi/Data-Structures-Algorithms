// O(N) O(1)
class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int lca = getLCA(a, b);
            int LCAtoA = log2(a) - log2(lca);
            int LCAtoB = log2(b) - log2(lca);
            int answer = LCAtoA + LCAtoB + 1;
            res[i] = answer;
        }
        return res;
    }
    
    private int getLCA(int a, int b) {
        while (a != b) {
            if (log2(a) > log2(b)) {
                a = a/2;
            }
            else if (log2(b) > log2(a)) {
                b = b/2;
            }
            else a = a/2; 
        }
        return a; // or b
    }
    
    private int log2(int a) {
        // log(a) base b = log10(a)/log10(b) 
        // we want base 2 so b =2
        // log(a) base 2 = log10(a)/log10(2)
        return (int)(Math.log(a)/Math.log(2));
    }
    
}