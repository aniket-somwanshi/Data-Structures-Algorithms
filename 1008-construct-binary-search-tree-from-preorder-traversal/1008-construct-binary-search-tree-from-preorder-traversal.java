// O(N) O(H)
// go to left, try to see if this next index node can be created here,
// ie check if it satisfies the upper bound. 
// Cos it has to be lesser than the current node, as it's on the left
// Similarly, for the right, just check with same upper bound that came from parent,
// cos right node has to be greater than node(no need to check that) and
// it needs to be smaller than the running upper bound
class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        
        return construct(preorder, Long.MAX_VALUE);
    }
    
    private TreeNode construct(int[] preorder, long upperBound) {
        if (index >= preorder.length) return null;
        
        if (preorder[index] >= upperBound) return null;
        
        // valid
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        
        node.left = construct(preorder, node.val);
        
        node.right = construct(preorder, upperBound);
        
        return node;
    }  
}