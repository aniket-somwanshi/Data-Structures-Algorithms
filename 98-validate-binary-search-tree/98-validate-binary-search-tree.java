/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean isValid(TreeNode root, long minimum, long maximum) {
        if (root == null) return true;
        if (root.val <= minimum || root.val >= maximum) 
            return false; 
        return isValid(root.left, minimum, root.val) && 
            
             isValid(root.right, root.val, maximum); 
    }
   
}