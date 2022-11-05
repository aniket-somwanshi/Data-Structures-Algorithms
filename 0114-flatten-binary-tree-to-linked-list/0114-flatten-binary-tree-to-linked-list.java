class Solution {
    TreeNode lastNode;
    public void flatten(TreeNode node) {
        if (node == null) return;
        
        lastNode = node;
        
        flatten(node.left);
        
        TreeNode currentLastNode = lastNode;
        
        flatten(node.right);
        
        TreeNode prevRight = node.right;
        node.right = node.left;
        node.left = null;
        currentLastNode.right = prevRight;
    }
}