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
    public TreeNode pruneTree(TreeNode root) {
        if (isValid(root)) return root;
        else return null;
    }
    
    private boolean isValid(TreeNode node) {
        if (node == null) return false;
        
        boolean isEitherSubtreeValid = false;
        if (isValid(node.left) == false) {
            node.left = null;
        } 
        else isEitherSubtreeValid = true;
        if (isValid(node.right) == false) {
            node.right = null;
        }
        else isEitherSubtreeValid = true; 
        
        if (isEitherSubtreeValid == true || node.val == 1) 
            return true;
        else return false;
    }
}