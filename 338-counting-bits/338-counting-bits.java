class Solution {
  public int[] countBits(int n) {
    int[] res = new int[n + 1];
    if(n == 0){
        return res;
    }
    int i = 1;
    while(true){
        for(int j = i; j < (2 * i); j++){
            res[j] = res[j - i] + 1;
            if(j == n){
                return res;
            }
        }
        i *= 2;
    }
}
}