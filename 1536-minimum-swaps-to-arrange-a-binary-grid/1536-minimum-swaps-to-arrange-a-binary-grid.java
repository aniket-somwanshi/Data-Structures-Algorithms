class Solution {
    public int minSwaps(int[][] a) {
        int res = 0;
        int n = a.length;
        
        int[] suffixZeros = new int[n];
        
        for (int i = 0; i < n; i++) {
            int suffixLength = 0;
            for (int j = n-1; j >= 0; j--) {
                if (a[i][j] != 0) {
                    break;
                } 
                else suffixLength++;
            }
            suffixZeros[i] = suffixLength;
        }
        
        // iterate over each row
        // if current row is not valid, then go down finding a valid row
        // when found, count how many rows away is it and add that to res
        // shift each row's value to the next row in the suffixZero[] array
        // if no valid row is found, then return -1
        
        for (int i = 0; i < n; i++) {
            int row = i;
            int requiredMinimumSuffixZeros = n-i-1;
            
            if (suffixZeros[i] >= requiredMinimumSuffixZeros) {
                continue;
            }
            
            int j = i+1;
            while (j < n && suffixZeros[j] < requiredMinimumSuffixZeros) {
                j++;
            }
            
            if (j == n) return -1;
                    
            // j is the next valid one
            int cost = j-i;
            res += cost;
            
            // shift 
            for (int k = j; k > i; k--) {
                suffixZeros[k] = suffixZeros[k-1];
            }
            
        }
        
        return res;
    }
}