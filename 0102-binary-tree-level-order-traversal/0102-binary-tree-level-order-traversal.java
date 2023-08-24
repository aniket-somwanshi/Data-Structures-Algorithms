class Solution {
    Map<Integer, List<Integer>> map;
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        map = new HashMap<>();
        dfs(root, 0);
        int size = map.size();
        for (int i = 0; i < size; i++) {
            res.add(map.get(i));
        }
        return res;
    }
    
    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        
        dfs(node.left, depth+1);
        
        if (!map.containsKey(depth)) map.put(depth, new ArrayList<>());
        map.get(depth).add(node.val);
        
        dfs(node.right, depth+1);
    }
}