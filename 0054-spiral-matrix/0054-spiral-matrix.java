class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        
        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = cols-1;
        List<Integer> res = new ArrayList<>();
        
        while (left <= right && bottom >= top) {
            for (int i = left; i <= right; i++) {
                res.add(a[top][i]);
            }
            top++;

            if (left > right || bottom < top) break;
            
            for (int i = top; i <= bottom; i++) {
                res.add(a[i][right]);
            }
            right--;
            
            if (left > right || bottom < top) break;
            
            for (int i = right; i >= left; i--) {
                res.add(a[bottom][i]);
            }
            bottom--;
            
            if (left > right || bottom < top) break;
            
            for (int i = bottom; i >= top; i--) {
                res.add(a[i][left]);
            }
            left++;
            
            
        }

        
        return res;
    }
}