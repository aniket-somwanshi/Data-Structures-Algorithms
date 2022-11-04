// O(logN*logN) O(logN) 
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        return getNumberOfNodes(root);
    }
    
    private int getNumberOfNodes(TreeNode node) {
        if (node == null) return 0;
        
        if (getLeftHeight(node) == getRightHeight(node)) {
            return (int)Math.pow(2, getLeftHeight(node)) - 1;
        }
        else {
            return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
        }
    }
    
    private int getLeftHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + getLeftHeight(node.left);
    }
    
    private int getRightHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + getRightHeight(node.right);
    }

}

// // O(N) O(H) 
// class Solution {
//     int missing = 0;
//     boolean foundLastLevel = false;
//     int maxDepth = 0;
//     public int countNodes(TreeNode root) {
//         if (root == null) return 0;
//         maxDepth = getMaxDepth(root);
//         maxDepth++;
//         getMissingNodes(root, 0);
//         int total = (int)Math.pow(2, maxDepth+1) - 1;
//         return total - missing;
//     }
    
//     private void getMissingNodes(TreeNode node, int depth) {
//         if (foundLastLevel) return;
        
//         if (depth == maxDepth) {
//             foundLastLevel = true;
//             return;
//         }
        
//         if (node == null) return;
        
//         if (node.right == null) {
//             missing++;
//         }
//         else {
//             getMissingNodes(node.right, depth + 1);
//         }
        
//         if (node.left == null) {
//             missing++;
//         }
//         else {
//             getMissingNodes(node.left, depth + 1);
//         }
        
//     }
    
//     private int getMaxDepth(TreeNode node) {
//         if (node.right == null) return 0;
//         return 1 + getMaxDepth(node.right);
//     }
    
// }