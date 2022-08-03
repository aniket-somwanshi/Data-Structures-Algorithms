class Solution {
    public boolean isPerfectSquare(int num) {
        long s = 1; long e = num;
        
        while(s <= e) {
            long mid = s +( e- s) / 2;
            long t = mid * mid;
            if (t < num) {
                s = mid + 1;
            } else if (t > num) {
                e = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
			