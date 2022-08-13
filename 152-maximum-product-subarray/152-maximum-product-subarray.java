class Solution {
    /*
    1: O(N) O(N)
    a highly negative number become highly positive value,
    if it's multiplied by a negative number 
    so we keep track of the minimum subarry product at each index
    and max subarry product at each index 
    so we can multiply with current number to get a possible max 
    */
    public int maxProduct(int[] a) {
        // check for edge cases 
        // if there are no positive elements
        // 1: there is only one element and that is negative
        // 2: there is single and negative number and also a zero, 
        // and there are no positives : answer is 
        
        // 1
       // if (a.length == 1) return a[0];
        
        // 2
//         boolean has_positive = false;
//         boolean has_zero = false;
//         int negatives = 0;
//         boolean zero_ans = false;
//         int maximum = Integer.MIN_VALUE;
//         for (int num: a) {
//             if (num > 0) { 
//                 has_positive = true;
//                 break;
//             }
//             if (num < 0) {
//                 negatives++;
//             }
//             if (num == 0) {
//                 if (negatives > 1) zero_ans = true;
//                 has_zero = true;
//                 // reset negatives
//                 negatives = 0;
//             }
//             maximum = Math.max(maximum, num);
//         }
        
//         if (!has_positive && has_zero && zero_ans) return 0;
        
        
        int current_min = a[0];
        int current_max = a[0];
        int maxi = a[0];
        for (int i = 1; i < a.length; i++) {
            int og_current_max = current_max;
            current_max = Math.max(a[i], Math.max(a[i] * current_max, a[i] * current_min));
            current_min = Math.min(a[i], Math.min(a[i] * og_current_max, a[i] * current_min));
            
            maxi = Math.max(maxi, current_max);
        
        }
        return maxi;
    }
}