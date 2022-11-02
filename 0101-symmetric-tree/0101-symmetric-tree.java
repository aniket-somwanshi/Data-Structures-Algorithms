// O(N) O(H) -- dfs
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isValid(root.left, root.right);
    }
    
    private boolean isValid(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null) return false;
        if (node2 == null) return false;
        
        if (node1.val != node2.val) return false;
        
        return isValid(node1.left, node2.right) && 
            isValid(node1.right, node2.left);
    }
}