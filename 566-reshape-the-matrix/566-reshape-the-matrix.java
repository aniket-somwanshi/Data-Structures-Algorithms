class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length*mat[0].length)
            return mat;
        int[][] res = new int[r][c];
        int currR = 0;
        int currC = 0;
        for(int i=0; i<mat.length;i++){
            for(int j=0; j<mat[0].length;j++){
                res[currR][currC] = mat[i][j];
                currC++;
                if(currC == c){
                    currR++;
                    currC = 0;
                }
            }
        }
        return res;
    }
}