class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0] != 0? i1[0] - i2[0] : i2[1] - i1[1]);
        int end = intervals[0][1];
        int rem = intervals.length;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][1] <= end)
                rem--;
            end = Math.max(end, intervals[i][1]); 
        }
        return rem;
    }
}