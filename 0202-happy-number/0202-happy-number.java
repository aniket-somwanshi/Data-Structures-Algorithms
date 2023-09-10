// Floyd's cycle detection algorithm 
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        System.out.println(nextSequence(n));
        int fast = nextSequence(n);
        while (true) {
            System.out.println(slow+"-"+fast);
            if (fast == 1) return true;
            if (slow == fast) return false;
            slow = nextSequence(slow);
            fast = nextSequence(nextSequence(fast));
        }
    }
    
    private int nextSequence(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n%10) * (n%10);
            n = n/10;
        }
        return sum;
    }
}