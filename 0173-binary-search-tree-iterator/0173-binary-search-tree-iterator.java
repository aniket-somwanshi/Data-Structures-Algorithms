class BSTIterator {
    TreeNode node;
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        node = root;
        s = new Stack<>();
    }
    
    // O(1) average for entire tree O(H)
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
    
    // O(1) 
    public boolean hasNext() {
        if (node != null || !s.isEmpty()) {
            return true;
        }
        return false;
    }
}