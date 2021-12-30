class Solution {
    public Node connect(Node root) {
        // base case
        if(root == null)
            return null;
        
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        
        Node dequeuedNode = null;
        while(bfsQueue.size() > 0){
            int bfsQueueSize = bfsQueue.size();
            while(bfsQueueSize > 0){
                dequeuedNode = bfsQueue.poll();
				// since we poll the last node from the bfsQueue,
				//there won't be any node to point to the dequeuedNode's next
				// so, we point to null, when bfsQueueSize is 1
                if(bfsQueueSize == 1)
                    dequeuedNode.next = null;
                else
                    dequeuedNode.next = bfsQueue.peek();
                
                // enqueue the children of dequeuedNode
                if(dequeuedNode.left != null)
                    bfsQueue.add(dequeuedNode.left);
                if(dequeuedNode.right != null)
                    bfsQueue.add(dequeuedNode.right);
                
                bfsQueueSize--;
            }
        }
        return root;
    }
}