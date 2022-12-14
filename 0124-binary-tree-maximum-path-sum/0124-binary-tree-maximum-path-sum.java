class Solution {
    long maxi;
    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE;
        getMaxSum(root);
        return (int)maxi;
    }
    
    private long getMaxSum(TreeNode node) {
        if (node == null) return 0;
        
        maxi = Math.max(maxi, node.val);
        
        long leftMaxSum = getMaxSum(node.left);
        
        long rightMaxSum = getMaxSum(node.right);
        
        
        
        // if sum coming from left subtree is negative, it weakens our answer
        // so don't propogate it upwards
        leftMaxSum = leftMaxSum < 0 ? 0 : leftMaxSum;
        
        rightMaxSum = rightMaxSum < 0 ? 0 : rightMaxSum;
        
        
        // connecting the left and right paths
        maxi = Math.max(maxi, leftMaxSum + rightMaxSum + node.val);
        
        // carry upwards the path which is gives more sum
        maxi = Math.max(maxi, Math.max(leftMaxSum, rightMaxSum) + node.val);
        
        return Math.max(leftMaxSum, rightMaxSum) + node.val;
    }
}
