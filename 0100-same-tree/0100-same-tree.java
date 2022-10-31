// O(N) O(H) --iterative
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) return false;
        if (q == null && p != null) return false;
        if (p == null) return true;
        
        Queue<TreeNode> a = new LinkedList<>();
        Queue<TreeNode> b = new LinkedList<>();
        a.add(p);
        b.add(q);
        
        while (!a.isEmpty() && !b.isEmpty()) {
            int size1 = a.size();
            int size2 = b.size();
            if (size1 != size2) return false;
            
            for (int i = 0; i < size1; i++) {
                TreeNode c1 = a.poll();
                TreeNode c2 = b.poll();
                
                if (c1.val != c2.val) return false;
                
                if (c1.left == null && c2.left == null) {
                    
                }
                else if (c1.left != null && c2.left != null) {
                    a.add(c1.left);
                    b.add(c2.left);
                }
                else {
                    return false;
                }
                
                if (c1.right == null && c2.right == null) {
                    
                }
                else if (c1.right != null && c2.right != null) {
                    a.add(c1.right);
                    b.add(c2.right);
                }
                else {
                    return false;
                }
            }
        }
        
        return a.isEmpty() && b.isEmpty();
    }
}

// // O(N) O(H) --recursive
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if (p == null && q != null) return false;
//         if (q == null && p != null) return false;
//         if (p == null) return true;
//         if (p.val != q.val) return false;
//         return isSameTree(p.left, q.left) && 
//             isSameTree(p.right, q.right);   
//     }
// }