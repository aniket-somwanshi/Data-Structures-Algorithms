// O(N) O(N) TLE
// class Solution {
//     public double myPow(double x, int n) {
//         if (n == 0) return 1;
//         if (n < 0) return 1/myPow(x, -n);
//         else return x * myPow(x, n-1);
//     }
// }

// O(N) O(N)
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        double t = myPow(x, n/2);
        if (n % 2 == 0) { 
            return t * t;
        }
        else {
            return n > 0 ? t * t * x : t * t / x;
        }
    }
}