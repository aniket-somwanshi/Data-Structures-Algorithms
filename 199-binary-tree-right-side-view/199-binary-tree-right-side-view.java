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
    // O(N) O(height)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        dfs(0, root, res);
        return res;
    }
    // depth = level
    private void dfs(int depth, TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (res.size() <= depth) {
            res.add(node.val);
        }
        dfs(depth + 1, node.right, res);
        dfs(depth + 1, node.left, res);
    }
    
}