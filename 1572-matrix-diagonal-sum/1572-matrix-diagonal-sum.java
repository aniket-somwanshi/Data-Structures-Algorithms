class Solution {
    public int diagonalSum(int[][] mat) {

        int sum=0,i=0,j=0;
  while(i<=mat.length-1 && j<=mat.length-1){
                if(i==j){
                    sum = sum+mat[i][j];
                }
        i++;j++;
            
        }
        int x=mat.length-1,y=mat.length-1,a=0,b=0;
        while(a<x && b<y){
             sum = sum+mat[a][x];
             sum=sum+mat[y][b];
            a++;x--;y--;b++;
        }
       
        return sum;
        
    }
}