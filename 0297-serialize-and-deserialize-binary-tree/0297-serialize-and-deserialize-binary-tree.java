// preorder (DFS)
// serialize: O(N) O(N)
// deserialize: O(N) O(N)
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> encoded = new ArrayList<>();
        
        if (root == null) return "";
        
        // preorder traversal
        preorder(root, encoded);
        
        return String.join(",", encoded);
    }
    
    private void preorder(TreeNode node, List<String> encoded) {
        if (node == null) {
            encoded.add("#");
            return;
        }
        
        encoded.add(String.valueOf(node.val));
        
        //left
        preorder(node.left, encoded);
        //right
        preorder(node.right, encoded);
        
        
    }
    
    private int i;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        
        String[] encoded = data.split(",");
        int n = encoded.length;
        i=0;
        return createTree(encoded);
    }
    
    private TreeNode createTree(String[] a) {
        if (a[i].equals("#")) {
            i++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(a[i++]));
        
        node.left = createTree(a);
        node.right = createTree(a);
        
        return node;
    }
}

// // Level Order (BFS)
// // serialize: O(N) O(N)
// // deserialize: O(N) O(N)
// public class Codec {

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         List<String> encoded = new ArrayList<>();
        
//         if (root == null) return "";
        
//         // level order traversal
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
        
//         boolean legitNodesAdded = true;
//         while (!q.isEmpty()) {
//             if (!legitNodesAdded) break;
//             legitNodesAdded = false;
            
//             int size = q.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode current = q.poll();
//                 if (current == null) encoded.add("#"); 
//                 else {
//                     encoded.add(String.valueOf(current.val));
//                     if (current.left != null || current.right != null) legitNodesAdded = true;
//                     q.add(current.left);
//                     q.add(current.right);
//                 }
//             }
//         }
//         return String.join(",", encoded);
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         if (data == "") return null;
        
//         String[] encoded = data.split(",");
//         int n = encoded.length;
//         TreeNode[] nodes = new TreeNode[n];
//         // create nodes
//         for (int i = 0; i < n; i++) {
//             if (encoded[i].equals("#")) continue;
//             nodes[i] = new TreeNode(Integer.valueOf(encoded[i]));
//         }
        
//         // create child links
//         int childPointer = 0;
//         for (int i = 0; i < n; i++) {
//             if (nodes[i] == null) continue;
            
//             TreeNode current = nodes[i];
//             current.left = childPointer + 1 < n ? nodes[++childPointer] : null;
//             current.right = childPointer + 1 < n ? nodes[++childPointer] : null;
            
//         }
        
//         return nodes[0];
//     }
    
   
// }

// // Your Codec object will be instantiated and called as such:
// // Codec ser = new Codec();
// // Codec deser = new Codec();
// // TreeNode ans = deser.deserialize(ser.serialize(root));