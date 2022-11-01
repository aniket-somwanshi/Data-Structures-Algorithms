class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode node, int h) {
        if (node == null) return;
        if (res.size() <= h) {
            res.add(new LinkedList<>());
        }
        if (h % 2 == 1) {
            ((LinkedList<Integer>)res.get(h)).addFirst(node.val);
        }
        else res.get(h).add(node.val);
        
            dfs(node.left, h+1);
            dfs(node.right, h+1);
    }
}