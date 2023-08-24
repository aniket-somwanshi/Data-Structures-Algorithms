class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        populateLeftBoundary(st, root);
        populateInorder(st, res);
        return res;
    }
    
    private void populateInorder(Stack<TreeNode> st, List<Integer> res) {
        while (!st.isEmpty()) {
            TreeNode current = st.pop();
            res.add(current.val);
            populateLeftBoundary(st, current.right);
        }
    }
    
    private void populateLeftBoundary(Stack<TreeNode> st, TreeNode current) {
        while (current != null) {
            st.push(current);
            current = current.left;
        }
    }
    
}