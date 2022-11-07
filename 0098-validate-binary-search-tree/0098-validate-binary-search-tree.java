class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean validate(TreeNode node, long mini, long maxi) {
        if (node == null) return true;
        
        if (node.val <= mini) {
            System.out.println(node.val + "<=" + mini);
            return false;
        }
        if (node.val >= maxi) {
            System.out.println(node.val + ">=" + maxi);
            return false;
        }
        
        return validate(node.left, mini, node.val)
            && validate(node.right, node.val, maxi);
    }
}