// O(N) O(N)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        if (node == p || node == q) return node;
        TreeNode leftRes = lowestCommonAncestor(node.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(node.right, p, q);
        if (leftRes != null && rightRes != null) return node;
        if (leftRes != null) return leftRes;
        if (rightRes != null) return rightRes;
        return null;
    }
}