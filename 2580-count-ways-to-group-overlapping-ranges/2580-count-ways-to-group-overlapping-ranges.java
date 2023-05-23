class Solution {
    public int countWays(int[][] ranges) {
        int n = ranges.length;
        Arrays.sort(ranges, (a,b)->a[0]-b[0]);
        int endPoint = ranges[0][1];
        int distincts = 1;
        for (int i = 1; i < n; i++) {
            if (ranges[i][0] > endPoint) {
                distincts++;
            }
            endPoint = Math.max(endPoint, ranges[i][1]);
        }
        // int res = (int)(0L + (long)Math.pow(2, distincts) % 1000000007);
        System.out.println(distincts);
        int a=1;
        for(int i=0;i<distincts;i++){
            a=(int)(1L * a*2% 1000000007);
        }
        return a;
    }
    int MOD = 1000000007;
  private int calcPower(int base, int power)  //modulo exponentation
  {
      long ans = 1;
      while(power > 0)
      {
          if (power % 2 != 0) 
          {
              ans = (ans * (long)base) % MOD; 
              power--; 
          }
          else 
          {
              power = power / 2;
              base = (int)(base * (long)base) % MOD;
          }
      }
      return (int)ans;
  }
}