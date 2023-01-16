class Solution {
    // O(N) O(N)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // handle 0 intervals
        
        int i = 0;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        
        List<int[]> res = new LinkedList<>();
        
        boolean foundStart = false;
        boolean foundEnd = false;
        
        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            // newInterval's start is greater than current end
            if (end < newStart) {
                res.add(new int[] {start, end});
                i++;
                continue;
            }
            
            // newInterval ends before this
            if (newEnd < start) {
                res.add(new int[] {newStart, newEnd});
                foundEnd = true;
                foundStart = true;
                break;
            }
            
            // newInterval's start intersects
            if (start <= newStart && newStart <= end) {
                newStart = start;
                foundStart = true;
            }
            
            // newInterval's end intersects
            if (start <= newEnd && newEnd <= end) {
                res.add(new int[] {newStart, end});
                i++;
                foundEnd = true;
                foundStart = true;
                break;
            }
            i++;
        }
        
        while (i < intervals.length) {
            res.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        
        if (!foundStart || !foundEnd) {
            res.add(new int[] {newStart, newEnd});
        }
        
        return listToArray(res);
    }
    
    private int[][] listToArray(List<int[]> a) {
        int[][] res = new int[a.size()][2]; 
        for (int i = 0; i < a.size(); i++) {
            res[i] = new int[]{a.get(i)[0], a.get(i)[1]};
        }
        return res;
    }
}