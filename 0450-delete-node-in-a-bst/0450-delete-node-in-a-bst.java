// O(H) O(H) 
class Solution {
     public TreeNode deleteNode(TreeNode node, int key) {
         if (node == null) return null;
         
         // search the node
         if (node.val > key) node.left = deleteNode(node.left, key);
         else if (node.val < key) node.right = deleteNode(node.right, key);
         
         else { // found the node to be deleted 
             
             // if there is no left child, 
             // just return the right child & vice versa
             if (node.left == null) return node.right;
             if (node.right == null) return node.left;
             
             // here the node has both left and right subtree
             // the values that can replace this node is the
             // smallest guy in the right subtree 
             // as it will be greater than the leftsubtree & 
             // smaller than the rest of the right subtree
             // we place this at the current node
             int successor = getMin(node.right);
             node.val = successor;
             
             // so there is a duplicate of this node as well, 
             // in the right subtree. So delete that as well
             node.right = deleteNode(node.right, successor);
         }
         return node;
     }
    
    private int getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

}
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
// // wrong approach
// class Solution {
//     public TreeNode deleteNode(TreeNode node, int key) {
//         if (node == null) return null;
        
//         if (node.val == key) {
            
//             if (node.left == null && node.right == null) return null;
            
//             TreeNode leftOfDeleted = node.left;
//                 TreeNode newBelow = getBelowFromRight(node.right);
//                 node = newBelow;
//                 newBelow.left = leftOfDeleted;
//                 return node;
//         }
        
//         TreeNode root = node;
//         while (node != null) {
//             if (node.left != null && node.left.val == key) {
//                 TreeNode leftOfDeleted = node.left.left;
//                 TreeNode newBelow = getBelowFromRight(node.left.right);
//                 node.left = newBelow;
//                 newBelow.left = leftOfDeleted;
//                 break;
//             }
//             else if (node.right != null && node.right.val == key) {
//                 TreeNode rightOfDeleted = node.right.right;
//                 TreeNode newBelow = getBelowFromLeft(node.right.left);
//                 node.right = newBelow;
//                 newBelow.right = rightOfDeleted;
//                 break;
//             }
//             if (node.val > key) {
//                 node = node.left;
//             }
//             else node = node.right;
//         }
//         return root;
//     }
    
//     private TreeNode getBelowFromRight(TreeNode node) {
//         if (node == null) return null;
//         TreeNode sendUp = node;
//         TreeNode below = getBelowFromRight(node.right);
//         sendUp.right = below;
//         return sendUp;
//     }
    
//     private TreeNode getBelowFromLeft(TreeNode node) {
//         if (node == null) return null;
//         TreeNode sendUp = node;
//         TreeNode below = getBelowFromLeft(node.left);
//         sendUp.left = below;
//         return sendUp;
//     }
// }