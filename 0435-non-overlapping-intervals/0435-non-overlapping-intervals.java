class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int prev = 0;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[prev][0] <= intervals[i][0] && 
               intervals[i][0] < intervals[prev][1]) {
                count++;
                
                if (intervals[prev][1] >= intervals[i][1]) {
                    prev = i;   
                }
                else {
                    prev = prev;
                }
            }
            else {
                prev = i;
            }
        }
        return count;
    }
}