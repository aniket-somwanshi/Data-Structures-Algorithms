class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res, 1);
        return res;
    }
    
    private void dfs(TreeNode node, List<Integer> res, int level) {
        if (node == null) return;
        if (res.size() < level) res.add(node.val);
        dfs(node.right, res, level + 1);
        dfs(node.left, res, level + 1);
    }
}