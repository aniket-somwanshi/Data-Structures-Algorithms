class Solution {
    // O(N + ~N) O(1) -- Morris preorder traversal for constant space
    public int sumRootToLeaf(TreeNode root) {
        TreeNode current = root;
        int res = 0;
        int currentNumber = 0;
        while (current != null) {
            if (current.left == null) {
                // print current 
                currentNumber = currentNumber * 2 + current.val;
                if (current.right == null) {
                    // this is lead node, update res
                    res += currentNumber;
                }
                current = current.right;
            }
            else {
                TreeNode lastNode = current.left;
                int depth = 1;
                while (lastNode.right != null && lastNode.right != current) {
                    lastNode = lastNode.right;
                    depth++;
                }
                if (lastNode.right == null) {
                        // print current
                        currentNumber = currentNumber * 2 + current.val;

                        lastNode.right = current;
                        current = current.left;
                    }
                else {
                        // check if it's a leaf node, if so then add currentNumber to res
                        if (lastNode.left == null) {
                            res += currentNumber;
                        }

                        // backtrack currentNumber back to the root, as per the depth
                        for (int i = 0; i < depth; i++) {
                            currentNumber /= 2;
                        }
                        lastNode.right = null;
                        current = current.right;
                    }
                }
            }
        return res;
    }
    
    
    // O(N) O(N)
//     int res = 0;
//     public int sumRootToLeaf(TreeNode root) {
//         dfs(root, 0);
//         return res;
//     }
    
//     private void dfs(TreeNode node, int currentSum) {
//         currentSum = (currentSum * 2) + node.val;
        
//         if (node.left == null && node.right == null) {
//             res += currentSum;
//             return;
//         }
        
//         if (node.left != null) dfs(node.left, currentSum);
        
//         if (node.right != null) dfs(node.right, currentSum);
        
//     }
}