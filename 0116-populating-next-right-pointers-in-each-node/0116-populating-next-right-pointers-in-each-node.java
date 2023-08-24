// O(N) O(N) -- recursive
class Solution {
    public Node connect(Node root) {
        util(root);
        return root;
    }
    
    private void util(Node node) {
        if (node == null) return;
        
        if (node.left != null) {
            node.left.next = node.right;
            
            if (node.next != null) {
                node.right.next = node.next.left; 
            }
        }
        
        util(node.left);
        util(node.right);
    }
}

// // O(N) O(N) -- iterative
// class Solution {
//     public Node connect(Node root) {
//         if (root == null) return root;
        
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
        
//         while (!q.isEmpty()) {
//             int size = q.size();
//             Node prev = null;
//             while (size-- > 0) {
//                 Node node = q.poll();
//                 if (prev != null) {
//                     prev.next = node;
//                 }
//                 prev = node;
                
//                 // add children
//                 if (node.left != null) q.add(node.left);
//                 if (node.right != null) q.add(node.right);
                
//             }
//         }
        
//         return root;
//     }
// }