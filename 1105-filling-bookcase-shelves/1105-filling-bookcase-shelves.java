class Solution {
    Integer[][] memo;
    int[][] books;
    int shelfWidth;
    // O(N*M) O(N*M)) -- M = shelfWidth
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        this.memo = new Integer[n][shelfWidth+1];
        this.books = books;
        this.shelfWidth = shelfWidth;
        
        return dfs(0, 0, 0);
    }
    
    private int dfs(int i, int currentHeight, int widthUsed) {
        if (i == books.length) return currentHeight; 
        
        if (memo[i][widthUsed] != null) return memo[i][widthUsed];
        
        int ans = Integer.MAX_VALUE;
        
        // case 1: Cannot fit i in current shelf, so place it on new shelf
        ans = currentHeight + dfs(i+1, books[i][1], books[i][0]);
        
        // case2: Can fit i in current shelf, so place it in same shelf
        if (widthUsed + books[i][0] <= shelfWidth) {
            ans = Math.min(ans, dfs(i+1, Math.max(currentHeight, books[i][1]), widthUsed+books[i][0]));
        }
        return memo[i][widthUsed] = ans;
    }
}