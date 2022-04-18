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
    Integer k;
    Integer res;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.res = null;
        inorder(root);
        return res;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        if (res != null) return;
        inorder(node.left);
        if (--k == 0) {
            res = node.val;
        }
        inorder(node.right);
    }
}