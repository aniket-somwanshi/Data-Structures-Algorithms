class Solution {
    Boolean isUnBalanced = null; 
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isUnBalanced == null ? true : false;
    }
    
    private int dfs(TreeNode node) {
        if (isUnBalanced != null) return 0;
        if (node == null) return 0;
        
        int left = 1 + dfs(node.left);
        int right = 1 + dfs(node.right);
        
        if (Math.abs(right - left) > 1) isUnBalanced = true;
        
        return Math.max(left, right); 
    }
}