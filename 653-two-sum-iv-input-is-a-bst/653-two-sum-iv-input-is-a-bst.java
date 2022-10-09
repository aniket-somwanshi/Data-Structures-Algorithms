/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private boolean isReverse;
    
    private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root, boolean isReverse) {
        this.isReverse = isReverse;
        this.stack = new Stack<>();
        pushAllBoundaryNodes(root);
    }
    
    public boolean hasNext() {
        return this.stack.isEmpty() == false;
    }
    
    public int next() {
        TreeNode current = stack.pop();
        if (isReverse) pushAllBoundaryNodes(current.left);
        else pushAllBoundaryNodes(current.right);
        
        return current.val;
    }
    
    private void pushAllBoundaryNodes(TreeNode node) {
        if (node == null) return;
        stack.push(node);
        if (isReverse == true) pushAllBoundaryNodes(node.right);
        else pushAllBoundaryNodes(node.left);
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
        BSTIterator forwardItr = new BSTIterator(root, false); // next 
        BSTIterator reverseItr = new BSTIterator(root, true); // before
        
        int low = forwardItr.next();
        int high = reverseItr.next();
        
        while (low < high) {
            if (low + high == k) return true;
            if (low + high < k) low = forwardItr.next();
            else high = reverseItr.next();
        }
        return false;
    }
 
    
}