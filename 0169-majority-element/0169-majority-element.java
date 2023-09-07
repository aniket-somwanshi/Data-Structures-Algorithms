class Solution {
    public int majorityElement(int[] a) {
        int n = a.length;
        int current = a[0];
        int power = 1;
        
        for (int i = 1; i < n; i++) {
            if (a[i] == current) power++;
            else {
                power -= 1;
                if (power == 0) {
                    current = a[i];
                    power = 1;
                }
            }
        }
        
        return current;
    }
}