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
    Set<Integer> set;
    List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for (int node: to_delete) set.add(node);
        res = new LinkedList<>();
        
        TreeNode dummyParent = new TreeNode(0);
        if (!set.contains(root.val)) res.add(root);
        preorder(root, dummyParent);
        return res;
    }
    
    private void preorder(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (set.contains(parent.val)) {
            if (!set.contains(node.val)) res.add(node);
        }
        preorder(node.left, node);
        preorder(node.right, node);
        
        if (node.left != null && set.contains(node.left.val)) {
            node.left = null;
        }
        
        if (node.right != null && set.contains(node.right.val)) {
            node.right = null;
        }
        
    }
}