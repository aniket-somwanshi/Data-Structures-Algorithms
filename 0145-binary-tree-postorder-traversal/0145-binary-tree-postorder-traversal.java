// O(H) O(H) iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode current = s.pop();
            res.addFirst(current.val);
            
            if (current.left != null) s.push(current.left);
    if (current.right != null) s.push(current.right);
        }
        return res;
    }
}