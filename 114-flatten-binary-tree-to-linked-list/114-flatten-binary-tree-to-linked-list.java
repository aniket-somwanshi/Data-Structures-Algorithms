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
    TreeNode exhaustedNode = null;    
    public void flatten(TreeNode root) {
        if (root == null) return;
        recur(root);
    }
    
    
    private void recur(TreeNode node) {
        if (node == null) return;
        recur(node.right);
        recur(node.left);
        
        node.right = this.exhaustedNode;
        node.left = null;
        this.exhaustedNode = node;
    }
    
}