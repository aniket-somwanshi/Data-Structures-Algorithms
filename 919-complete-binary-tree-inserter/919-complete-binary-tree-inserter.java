/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    private TreeNode root;
    private Queue<TreeNode> q;
    
    public CBTInserter(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();
        q.add(root);
        
        // preprocess
        while (q.isEmpty() == false) {
            TreeNode node = q.peek();
            if (node.left == null || node.right == null) {
                if (node.left != null) {
                    q.add(node.left);
                }
                break;
            }
            q.poll();
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right); 
        }
    }
    
    
    public int insert(int val) {
        TreeNode node = q.peek();
        TreeNode newNode = new TreeNode(val);
        q.add(newNode);
        if (node.left == null) {
            node.left = newNode;
        }
        else {
            node.right = newNode;
            // now the node is full, so remove it from q
            q.poll();
        }
        return node.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */