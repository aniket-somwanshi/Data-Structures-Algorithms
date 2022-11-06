// O(N) O(1) -- iterative  
class Solution {
    public int kthSmallest(TreeNode node, int k) {
        if (node == null) return -1;
        
        int index = 0;
        Stack<TreeNode> s = new Stack<>();
        
        while (node != null || !s.isEmpty()) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            
            node = s.pop();
            if (++index == k) return node.val;
            
            node = node.right;
        }
        
        return -1;
    }
}

// // O(N) O(H) 
// class Solution {
//     int index = 0;
//     public int kthSmallest(TreeNode node, int k) {
//         if (node == null) return -1;
        
//         int left = kthSmallest(node.left, k);
//         if (left != -1) return left;
        
//         if (++index == k) return node.val;
        
//         int right = kthSmallest(node.right, k);
//         if (right != -1) return right;
        
//         return -1;
//     }
// }