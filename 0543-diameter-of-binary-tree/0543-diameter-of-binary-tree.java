// O(N) O(H)
class Solution {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return maxDiameter;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    } 
}