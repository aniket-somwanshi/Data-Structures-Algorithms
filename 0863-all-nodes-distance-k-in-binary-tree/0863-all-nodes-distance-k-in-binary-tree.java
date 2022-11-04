// O(N + N) O(N + N + N)
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        
        if (k == 0) {
            res.add(target.val); return res;
        }
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        populateParents(root, null, parent);
        
        // bfs
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        set.add(target);
        
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                
                if (level == k) res.add(current.val);
                
                if (current.left != null && !set.contains(current.left)) {
                    q.add(current.left); set.add(current.left);
                }
                if (current.right != null && !set.contains(current.right)) {
                    q.add(current.right); set.add(current.right);
                }
                if (parent.get(current) != null && !set.contains(parent.get(current))) {
                    q.add(parent.get(current)); set.add(parent.get(current));
                }
            }
            level++;
        }
        
        return res;
    }
    
    private void populateParents(TreeNode node, TreeNode p, Map<TreeNode, TreeNode> map) {
        if (node == null) return;
        if (p != null) map.put(node, p);
        populateParents(node.left, node, map);
        populateParents(node.right, node, map);
    }
    
}

// wrong solution
// class Solution {
//     List<Integer> res;
//     TreeNode target;
//     int k;
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//         this.res = new LinkedList<>();
//         this.target = target;
//         this.k = k;
        
//         if (k == 0) {
//             res.add(target.val);
//             return res;
//         }
        
//         dfs(root, -1);
        
//         return res;
//     }
    
//     private int dfs(TreeNode node, int targetDistanceFromAbove) {
//         if (node == null) return -1;
//         if (targetDistanceFromAbove == k) res.add(node.val);
        
//         boolean isTarget = node == target;
        
//         if (isTarget) {
//             dfs(node.left, 1);
//             dfs(node.right, 1);
//             return 1;
//         }
        
//         int left = dfs(node.left, -1);
//         if (left != -1) {
//             dfs(node.right, left + 1);
//             return left + 1;
//         }
        
//         int right = dfs(node.right, -1);
//         if (right != -1) {
//             dfs(node.left, right + 1);
//             return right + 1;
//         }
//         return -1;
//     }
// }