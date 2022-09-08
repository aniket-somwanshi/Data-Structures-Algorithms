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
    public List<Integer> inorderTraversal(TreeNode root) {
        // O(N), O(height)
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else if (node == null) {
                if (stack.isEmpty()) break; 
                TreeNode leftDone = stack.pop();
                res.add(leftDone.val);
                node = leftDone.right;
            }
        }
        return res;
    }
}