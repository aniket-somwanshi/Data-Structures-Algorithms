class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<int[]> points = new ArrayList<>(); // int[]{ point on x-axis, height }
        for (int[] building: buildings) {
            int start = building[0];
            int end = building[1];
            int height = building[2];
            points.add(new int[] {start, -height}); // add start point
            points.add(new int[] {end, height}); // add end point
        }
        
        Collections.sort(points, (x,y)->{
            if (x[0] == y[0]) return x[1]-y[1];
            else return x[0] - y[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0); // initial max height is 0
        
        int currentMaxHeight = 0;
        for (int[] point: points) {
            int pointX = point[0];
            int pointY = point[1];
            // if the point is a start point
            if (pointY < 0) {
                pq.add(-pointY); // add height to the pq
                if (pq.peek() != currentMaxHeight) {
                    // there is a height change. So add the point to res
                    res.add(Arrays.asList(pointX, -pointY));
                    // update the current max height
                    currentMaxHeight = pq.peek();
                }
            }
            else {
                pq.remove(pointY);
                if (pq.peek() != currentMaxHeight) {
                    res.add(Arrays.asList(pointX, pq.peek()));
                    currentMaxHeight = pq.peek();
                }
            }
        }
        
        return res;
    }
}