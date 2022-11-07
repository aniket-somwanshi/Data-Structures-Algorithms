
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) return lca(root, q, p);
        return lca(root, p, q);
    }
    
    private TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        
        if (p.val <= node.val && node.val <= q.val) return node;
        
        if (node.val < p.val) return lca(node.right, p, q);
        
        else return lca(node.left, p, q);
    }
    
    
}