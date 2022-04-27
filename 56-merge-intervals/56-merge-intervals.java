class Solution {
    // O(NlogN) O(1)
    public int[][] merge(int[][] intervals) {
        // sort according to starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); 
        int[][] res = new int[intervals.length][2];
        int lastPointer = 0;
        res[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (res[lastPointer][1] < intervals[i][0]) {
                lastPointer++;
                res[lastPointer] = intervals[i];
            }
            else if (res[lastPointer][1] >= intervals[i][0] || res[lastPointer][0] <= intervals[i][0]) {
                res[lastPointer][1] = Math.max(intervals[i][1], res[lastPointer][1]);
            }
             
        }
        
        
        int[][] ans = new int[lastPointer+1][2];
        for (int i = 0; i < lastPointer+1; i++) ans[i] = res[i];
        return ans;
        
    }
}