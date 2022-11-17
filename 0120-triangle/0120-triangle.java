class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] up = new int[rows];
        int maxCols = rows;
        up[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < rows; i++) {
            int[] current = new int[maxCols];
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    current[j] = up[j] + triangle.get(i).get(j);
                }
                else if (j == triangle.get(i).size()-1) {
                    current[j] = up[j-1] + triangle.get(i).get(j);
                }
                else {
                    current[j] = Math.min(up[j], up[j-1]) + triangle.get(i).get(j);
                }
            }
            up = current;
        }
        int res = Integer.MAX_VALUE;
        for (int candidate: up) {
            res = Math.min(res, candidate);
        }
        return res;
    }
}