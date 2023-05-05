class Solution {
    public long coloredCells(int n) {
        n--;
        long res = 4L*n*(2+(n-1))/2L;
        return res+1;
    }
}