/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // found a split
        if (p.val <= root.val && root.val <= q.val) return root;
        if (q.val <= root.val && root.val <= p.val) return root;
        // try to find split on either side
        if (q.val >= root.val) return lowestCommonAncestor(root.right, p, q); // can use p or q
        else return lowestCommonAncestor(root.left, p, q);
        
    }
}