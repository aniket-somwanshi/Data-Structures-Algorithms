class Solution {
       public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        return DFS(image,sr,sc,oldColor);
    }

    public int[][] DFS(int[][] image, int sr, int sc, int oldColor) {
        int[][] move = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < 4; i++) {
            int m = sr + move[i][0];
            int n = sc + move[i][1];
            if (m >= 0 && m < image.length && n >= 0 && n < image[0].length) {
                if (image[m][n] == oldColor) {
                    image[m][n] = image[sr][sc];
                    image = DFS(image, m, n, oldColor);
                }
            }
        }
        return image;
    }
    
}