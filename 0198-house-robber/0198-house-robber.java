class Solution {
    public int rob(int[] a) {
        if (a.length == 1) return a[0];
        int secondLast = a[0];
        int last = Math.max(a[0], a[1]);
        
        for (int i = 2; i < a.length; i++) {
            int current = Math.max(
                a[i] + secondLast, 
                last
            );
            secondLast = last;
            last = current;
        }
        return last;
    }
}