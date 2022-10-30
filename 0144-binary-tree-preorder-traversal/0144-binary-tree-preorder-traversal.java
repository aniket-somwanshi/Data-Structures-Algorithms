// O(H) O(H) Iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode current = s.pop();
            res.add(current.val);
            
            if (current.right != null) s.push(current.right);
            if (current.left != null) s.push(current.left);
        }
        return res;
    }
}

// // O(H) O(H) Recursive
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new LinkedList<>();
//         preorder(res, root);
//         return res;
//     }
    
//     private void preorder(List<Integer> res, TreeNode node) {
//         if (node == null) return;
//         res.add(node.val);
//         preorder(res, node.left);
//         preorder(res, node.right);
//     }
// }