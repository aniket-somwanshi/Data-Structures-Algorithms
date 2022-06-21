class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        // the matrix is completely sorted so we can use binary search
        // we can convert 2d [i][j] into a 1-d index
        int rows = a.length;
        int cols = a[0].length;
        int low = 0;
        int high = (rows*cols)-1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high-low)/2;
            
            int i = getCoordinates(mid, cols)[0];
            int j = getCoordinates(mid, cols)[1];
    
            if (a[i][j] == target) return true;
            
            else if (a[i][j] < target) low = mid+1;
            
            else high = mid-1;
        }
        return false;
    }
    
    private int getIndex(int i, int j, int cols) {
        int index = j + (cols * i);
        return index;
    }
    
    private int[] getCoordinates(int index, int cols) {
        int[] coords = new int[2];
        coords[0] = index/cols;
        coords[1] = index%cols;
        return coords;
    }
}