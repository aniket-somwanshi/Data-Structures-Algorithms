// O(N) O(H) -- DFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        dfs(root, res, 0);
        return res;
    }
    
    private void dfs(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) return;
        while (res.size() <= level) {
            res.add(new LinkedList<>());
        }
        res.get(level).add(node.val);
        
        dfs(node.left, res, level+1);
        dfs(node.right, res, level+1);
    }
}

// // O(N) O(B) -- BFS
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> res = new LinkedList<>();
//         if (root == null) return res;
        
//         Queue<TreeNode> level = new LinkedList<>();
//         level.add(root);
        
//         while (!level.isEmpty()) {
//             int size = level.size();
//             List<Integer> currLevel = new LinkedList<>();
//             for (int i = 0; i < size; i++) {
//                 TreeNode c = level.poll();
//                 currLevel.add(c.val);
//                 if (c.left != null) level.add(c.left);
//                 if (c.right != null) level.add(c.right);
//             }
//             res.add(currLevel);
//         }
//         return res;
//     }
// }