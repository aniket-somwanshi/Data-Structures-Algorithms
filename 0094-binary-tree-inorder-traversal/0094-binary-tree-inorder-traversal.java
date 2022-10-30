class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            if (s.peek() != null) {
                TreeNode current = s.pop();
                s.push(current.right);
                s.push(current);
                s.push(current.left);
            }
            else {
                s.pop();
                if (s.isEmpty()) break;
                res.add(s.pop().val);
            }
        }
        
        return res;
    }
}





// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         // O(N), O(height)
//         List<Integer> res = new ArrayList<>();
//         if (root == null) return res;
        
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode node = root;
//         while(true) {
//             if (node != null) {
//                 stack.push(node);
//                 node = node.left;
//             }
//             else if (node == null) {
//                 if (stack.isEmpty()) break; 
//                 TreeNode leftDone = stack.pop();
//                 res.add(leftDone.val);
//                 node = leftDone.right;
//             }
//         }
//         return res;
//     }
// }