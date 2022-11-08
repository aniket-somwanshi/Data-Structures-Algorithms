class BSTIterator {
    TreeNode node;
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        node = root;
        s = new Stack<>();
    }
    
    public int next() {
        while (node != null) {
            s.push(node);
            node = node.left;
        }
        node = s.pop();
        int res = node.val;
        node = node.right;
        return res;
    }
    
    public boolean hasNext() {
        if (node != null || !s.isEmpty()) {
            return true;
        }
        return false;
    }
}