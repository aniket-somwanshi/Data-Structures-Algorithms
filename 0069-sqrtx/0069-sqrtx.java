class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long left = 1;
        long right = Integer.MAX_VALUE;
        long res = 0;
        while (left <= right) {
         // System.out.println(left + "-" + right);
            long mid = left + (right - left)/2;
            if (mid*mid <= x) {
                res = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        // System.out.println(left + "-" + right);
        return (int)res; 
    }
}