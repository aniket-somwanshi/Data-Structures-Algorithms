class Solution {
    public int numOfSubarrays(int[] a) {
        int n = a.length;
        
        // Map<Integer, Integer> sumFreq = new HashMap<>();
        // sumFreq.put(0, 1);
        
        int res = 0;
        int sum = 0;
        
        int evenSumsSoFar = 1; // 0 elements
        int oddSumsSoFar = 0;
        
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum % 2 == 1) {
                res = (int) ((0L + res + evenSumsSoFar)%1000000007);
                oddSumsSoFar++;
            }
            else {
                res = (int) ((0L + res + oddSumsSoFar)%1000000007);
                evenSumsSoFar++;
            }
        }
        
        return res;
    }
}
//tle
// class Solution {
//     public int numOfSubarrays(int[] a) {
//         int n = a.length;
        
//         Map<Integer, Integer> sumFreq = new HashMap<>();
//         sumFreq.put(0, 1);
        
//         int res = 0;
//         int sum = 0;
//         for (int i = 0; i < n; i++) {
//             sum += a[i];
//             if (sum % 2 == 1) {
//                 // odd sum
//                 // search for every even sum previously encountered
//                 for (int num = 0; num <= sum; num += 2) {
//                     if (sumFreq.containsKey(num)) {
//                         res += sumFreq.get(num);
//                     }
//                 }
//             }
//             else {
//                 // even sum
//                 // search for every odd sum previously encountered
//                 for (int num = 1; num <= sum; num += 2) {
//                     if (sumFreq.containsKey(num)) {
//                         res += sumFreq.get(num);
//                     }
//                 }
//             }
//             sumFreq.put(sum, sumFreq.getOrDefault(sumFreq, 0) + 1);
//         }
        
//         return res;
//     }
// }