// O(N) O(N) -- iterative
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        q1.add(root.left);
        q2.add(root.right);
        
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            
            if ((n1 == null && n2 != null) || (n1 != null && n2 == null)) return false;
            
            if (n1 != null) {
                // (Note: n2 is never null here, based on above checks)
                if (n1.val != n2.val) return false;
                
                q1.add(n1.left);
                q1.add(n1.right);
                
                q2.add(n2.right);
                q2.add(n2.left);
            }
        }
        
        return true;
    }
}