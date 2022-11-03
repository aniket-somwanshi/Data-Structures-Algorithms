class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        TreeNode currentAns = root == p || root == q ? root : null;
        
        TreeNode leftAns = lowestCommonAncestor(root.left, p, q); 
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);
        
        if (currentAns != null && (leftAns != null || rightAns != null)) return root;
        if (leftAns != null && rightAns != null) return root;
        
        if (leftAns != null) return leftAns;
        if (rightAns != null) return rightAns;
        
        return currentAns;
    }
}