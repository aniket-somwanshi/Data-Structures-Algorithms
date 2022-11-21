// O(N*N) O(N*N) -- dp 
class Solution {
    public List<Integer> largestDivisibleSubset(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int[] LDSEndingAt = new int[n];
        for (int i = 0; i < n; i++) LDSEndingAt[i] = 1;
        
        int[] prevLDS = new int[n];
        for (int i = 0; i < n; i++) prevLDS[i] = i;
        
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                
                if (a[i] % a[prev] == 0) {
                    if (LDSEndingAt[prev] + 1 > LDSEndingAt[i]) {
                        LDSEndingAt[i] = LDSEndingAt[prev] + 1;
                        prevLDS[i] = prev; 
                    }
                }
                
            }
        }
        
        // get maxlength
        int maxLengthLDS = -1;
        int lastIndexNums = -1;
        for (int i = 0; i < n; i++) {
            if (LDSEndingAt[i] > maxLengthLDS) {
                maxLengthLDS = LDSEndingAt[i];
                lastIndexNums = i;
            }
        }
        
        
        // print it
        List<Integer> res = new ArrayList<>();
        while (prevLDS[lastIndexNums] != lastIndexNums) {
            res.add(a[lastIndexNums]);
            lastIndexNums = prevLDS[lastIndexNums];
        }
        res.add(a[lastIndexNums]);
        Collections.reverse(res);
        return res;
    }
}

// // O(N*N) O(N*N + N) -- memo (ONLY GETS "LENGTH" OF LDS)
// class Solution {
//     public List<Integer> largestDivisibleSubset(int[] a) {
//         int n = a.length;
//         Integer[][] memo = new Integer[n][n];
//         Arrays.sort(a);
//         int lengthOfLongestSubset = recur(0, -1, a, memo);
//         System.out.println(lengthOfLongestSubset);
//         List<Integer> res = new ArrayList<>();
//         return res;
//     }
    
//         private int recur(int i, int prevIndex, int[] a, Integer[][] memo) {
//         if (i == a.length) return 1;
        
//         if (prevIndex != -1 && memo[i][prevIndex] != null) return memo[i][prevIndex];  
        
//         int take = 0;
//         // take if possible  
//         if (prevIndex == -1 || a[prevIndex] % a[i] == 0) {
//             take = 1 + recur(i+1, i, a, memo);
//         }
        
//         // not take
//         int notTake = recur(i+1, prevIndex, a, memo);
        
//         int res = Math.max(take, notTake);
//         if (prevIndex != -1) memo[i][prevIndex] = res;
//         return res;
//     }
// }