class BSTIterator {
    boolean isReverse;
    Stack<TreeNode> s;
    
    public BSTIterator(TreeNode root, boolean isReverse) {
        this.isReverse = isReverse;
        this.s = new Stack<>();
        pushAllBoundaryNodes(root);
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    public int next() {
        TreeNode current = s.pop();
        if (isReverse) pushAllBoundaryNodes(current.left);
        else pushAllBoundaryNodes(current.right);
        return current.val;
    }
    
    private void pushAllBoundaryNodes(TreeNode node) {
        while (node != null) {
            s.push(node);
            node = isReverse ? node.right : node.left;
        }
    }

}

class Solution {
    // O(N) O(2H)
    // similar 2 pointer approach like two sum problem
    // first pointer is inorder traversal (small to bigger values as inorder is ascending)
    // second pointer is reverse inorder traversal (descending)
    // if sum of first and second pointer values is less than target
    // move forward the first one
    // else move forward the second one
    // if they meet, target sum doesn't exist
    
    // we create a BSTIterator that goes next and before
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        
        BSTIterator forwardItr = new BSTIterator(root, false);
        BSTIterator reverseItr = new BSTIterator(root, true);
        
        int low = forwardItr.next();
        int high = reverseItr.next();
        
        while (low < high) {
            if (low + high == k) return true;
            if (low + high > k) high = reverseItr.next();
            else low = forwardItr.next();
        }
        
        return false;
    }
 
    
}