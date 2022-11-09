// O(N*M) O(N*M)
class Solution {
    int[][] dir = new int[][] {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            dfs(sr, sc, image, color);
        }
        return image;
    }
    
    private void dfs(int i, int j, int[][] image, int color) {
        int myColor = image[i][j];
        image[i][j] = color;
        
        for (int[] direction: dir) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            
            if (isOutOfBounds(newX, newY, image)) continue;
            
            if (image[newX][newY] == myColor && image[newX][newY] != color) dfs(newX, newY, image, color);  
        }
    }
    
    private boolean isOutOfBounds(int i, int j, int[][] image) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length) return true;
        return false;
    }
}