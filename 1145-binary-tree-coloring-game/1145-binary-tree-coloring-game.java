class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // for node x,
        // get number of left subtree nodes
        // get number of right subtree nodes
        // get number of top nodes
        // if by cutting the biggest one of these 3, we are able to secure
        // more than half of the nodes, we can win
        
        TreeNode nodeX = getNodeX(root, x);
        
        int leftCount = countNodes(nodeX.left);
        int rightCount = countNodes(nodeX.right);
        
        int topCount = getTopCount(root, nodeX);
        
        int bestScope = Math.max(leftCount, Math.max(rightCount, topCount));
        
        int possibleScope = leftCount + rightCount + topCount + 1 - bestScope;
        
        return possibleScope < (n/2) + 1;
    }
    
    private int getTopCount(TreeNode node, TreeNode nodeX) {
        if (node == null) return 0;
        
        if (node == nodeX) return 0;
        
        return getTopCount(node.left, nodeX) + getTopCount(node.right, nodeX) + 1;
    }
    
    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return countNodes(node.left) + countNodes(node.right) + 1;
    }
    
    private TreeNode getNodeX(TreeNode node, int x) {
        if (node == null) return null;
        
        if (node.val == x) return node;
        
        TreeNode leftSearch = getNodeX(node.left, x);
        if (leftSearch != null) return leftSearch;
        
        TreeNode rightSearch = getNodeX(node.right, x);
        if (rightSearch != null) return rightSearch;
        
        return null;
    }
    
    
}