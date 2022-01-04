class Solution {
    public int rotatedDigits(int n) {
        int[] cache = new int[n+11];
        cache[0] = 0;
        cache[1] = 0;
        cache[2] = 1;
        cache[3] = -1;
        cache[4] = -1;
        cache[5] = 1;
        cache[6] = 1;
        cache[7] = -1;
        cache[8] = 0;
        cache[9] = 1;
        
        if (n <= 9) {
            if (n == 0) return 0;
            if (n == 1) return 0;
            if (n == 2) return 1;
            if (n == 3) return 1;
            if (n == 4) return 1;
            if (n == 5) return 2;
            if (n == 6) return 3;
            if (n == 7) return 3;
            if (n == 8) return 3;
            if (n == 9) return 4; 
        }
        
        int count = 4;
        for (int num = 10; num <= n; num++) {
            int prev = num/10;
            int current = num%10;
            cache[num] = cache[prev];
            if (cache[prev] == -1 || isInvalidDigit(current)) {
                cache[num] = -1;
            } 
            else if (isChangingDigit(current)) {
                cache[num] = 1;
            }
            // check if this turned out to be a good number
            if (cache[num] == 1) count++;
        }
        return count;
    }
    
    private boolean isChangingDigit(int num) {
        if (num == 2 || num == 5 || num == 6 || num == 9) return true;
        return false;
    }
     
    private boolean isInvalidDigit(int num) {
        if (num == 3 || num == 4 || num == 7) return true;
        return false;
    }
    
}