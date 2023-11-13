class Solution {
    int m = (int)1e9 + 7;
    long res = 0;
    long total = 0;
    public int maxProduct(TreeNode root) {
        total = getTotal(root);
        f(root);
        return (int)(res % m);
    }
    
    private long getTotal(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotal(node.left) + getTotal(node.right);
    }
    
    private long f(TreeNode node) {
        if (node == null) return 0;
        long left = f(node.left);
        long right = f(node.right);
        long candidate1 = (1L)*(total - left)*(left);
        res = Math.max(candidate1, res);
        long candidate2 = (1L)*(total - right)*(right);
        res = Math.max(candidate2, res);
        
        return node.val + left + right;
    }
}


// class Solution {
//     int m = (int)1e9 + 7;
//     long res = 0;
//     public int maxProduct(TreeNode root) {
//         f(root, 0);
//         return (int)res;
//     }
    
//     private long f(TreeNode node, long up) {
//         if (node == null) return 0;
        
//         long curr = node.val;
        
//         long leftSum = f(node.left, up + curr);
//         long rightSum = f(node.right, up + curr + leftSum);
        
//         leftSum = f(node.left, up + curr + rightSum);
        
//         res = Math.max(res, 
//                        (int)
//                        (1L * ((0L + up + leftSum + curr)*(0L + rightSum))) % m
//                       );
        
//         res = Math.max(res, 
//                        (int)
//                        (1L * ((0L + up + curr + rightSum)*(0L + leftSum))) % m
//                       );
        
//         res = Math.max(res, 
//                        (int)
//                        (1L * ((0L + curr + rightSum + leftSum)*(0L + up))) % m
//                       );
        
//         return curr + leftSum + rightSum;
//     }
// }