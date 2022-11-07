// O(N) O(H) -- iterative 
// inorder -- in an inorder travsersal, elements should be in increasing order, so if a node is not increasing, return false
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        TreeNode previous = null;
        
        while (!s.isEmpty() || node != null) {
            // push lefts first
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            
            // do 
            node = s.pop();
            if (previous != null && node.val <= previous.val) return false;
            
            // go to right
            previous = node;
            node = node.right;
        }
        return true;
    }
}







// O(N) O(H) -- recursive
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }
    
//     private boolean validate(TreeNode node, long mini, long maxi) {
//         if (node == null) return true;
        
//         if (node.val <= mini) {
//             System.out.println(node.val + "<=" + mini);
//             return false;
//         }
//         if (node.val >= maxi) {
//             System.out.println(node.val + ">=" + maxi);
//             return false;
//         }
        
//         return validate(node.left, mini, node.val)
//             && validate(node.right, node.val, maxi);
//     }
// }