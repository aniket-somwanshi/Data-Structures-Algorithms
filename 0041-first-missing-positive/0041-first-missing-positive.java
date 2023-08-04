class Solution {
    public int firstMissingPositive(int[] a) {
        int n = a.length;
        int i = 0;
        while (i < n) {
            if (a[i] == i+1 || a[i] <= 0 || a[i] > n) i++;
            else if (a[a[i]-1] != a[i]) swap(a, i, a[i]-1);
            else i++;
        }
        i = 0;
        while (i < n && i+1 == a[i]) {
            i++;
        }
        return i+1;
    }
    
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}