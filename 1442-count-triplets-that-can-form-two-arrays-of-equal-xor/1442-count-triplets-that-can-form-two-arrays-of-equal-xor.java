class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor = xor ^ arr[j];
                if (xor == 0) {
                    int subArrayLength = j-i+1;
                    res += subArrayLength-1;
                }
            }
        }
        
        return res;
    }
}