class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0]=false;
        if (n <= 2) return 0;
        isPrime[1]=false;
        for (int prime = 2; prime*prime <= n; prime++) {
           if (isPrime[prime]) {
                for (int j = prime*prime; j <= n; j=j+prime) {
                    isPrime[j] = false;
                }        
            }
        }
        int c=0;
        for(boolean b:isPrime) c+=b?1:0;
        return c-(isPrime[n]?1:0);
    }
}