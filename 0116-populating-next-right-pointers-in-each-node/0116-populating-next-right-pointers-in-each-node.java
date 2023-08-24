class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            while (size-- > 0) {
                Node node = q.poll();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                
                // add children
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                
            }
        }
        
        return root;
    }
}