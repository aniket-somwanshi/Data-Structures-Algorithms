/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Integer maxi;
    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE;
        f(root);
        return maxi;
    }
    
    private int f(TreeNode node) {
        if (node == null) return 0;
        
        int ls = f(node.left);
        int rs = f(node.right);
        
        maxi = Math.max(maxi, node.val);
        
        maxi = Math.max(maxi, ls + node.val + rs);
        
        maxi = Math.max(maxi, ls + node.val);
        
        maxi = Math.max(maxi, rs + node.val);
        
        return Math.max(node.val, Math.max(ls, rs) + node.val);
    }
}