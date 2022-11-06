class Solution {
    int index = 0;
    public int kthSmallest(TreeNode node, int k) {
        if (node == null) return -1;
        
        int left = kthSmallest(node.left, k);
        if (left != -1) return left;
        
        if (++index == k) return node.val;
        
        int right = kthSmallest(node.right, k);
        if (right != -1) return right;
        
        return -1;
    }
}