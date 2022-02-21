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
    // O(N) O(N)
    // create parent pointers for each node
    // run dfs from target
    // when we reach level k, add nodes to answer
    // stop and return
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new LinkedList<>();
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        populateParents(root, null, parent);
        
        // mark visited nodes
        Set<TreeNode> set = new HashSet<>();
    
        // bfs
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        while (q.isEmpty() == false) {
            int size = q.size();
            
            while (size-- > 0) {
                TreeNode current = q.poll();
                set.add(current);
                if (level == k) {
                    res.add(current.val);
                }
                if (level > k) return res;
                
                if (current.left != null && !set.contains(current.left))
                    q.add(current.left);
                if (current.right != null && !set.contains(current.right)) 
                    q.add(current.right);
                if (parent.get(current) != null && !set.contains(parent.get(current)))
                    q.add(parent.get(current));
                
            }
            level++;
        }
        
        return res;
    }
    
    private void populateParents(TreeNode node, TreeNode father, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, father);
        populateParents(node.left, node, parent);
        populateParents(node.right, node, parent);
    }
}