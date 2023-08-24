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
    public boolean isValidBST(TreeNode root) {
        return f(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean f(TreeNode node, long low, long high) {
        if (node == null) return true;
        
        // check if current node is in between the [low, high]
        
        if (low < node.val && node.val < high) {
            return f(node.left, low, node.val) && f(node.right, node.val, high);
        }
        return false;
    }
}