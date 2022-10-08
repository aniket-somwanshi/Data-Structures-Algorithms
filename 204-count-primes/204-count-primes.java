class Solution {
    public int countPrimes(int n) {
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);
        for (int prime = 2; prime < n; prime++) {
            if (sieve[prime] == false) continue;
            // mark his multiples as non-prime
            for (int j = 2 * prime; j < n; j += prime) {
                sieve[j] = false;
            }
        }
        //System.out.println(Arrays.toString(sieve));
        int c = 0;
        for (int i = 2; i <= n-1; i++) if (sieve[i]) c++;
        return c;
    }
}