// Pair class
class Pair <T, U>{
    T first;
    U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int maxiWidth = 0;
        
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            int size = q.size();
            // get the mini index
            int miniIndex = q.peek().second;
            
            int startLevel = 0;
            int endLevel = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = q.peek().first;
                
                int currentIndex = q.peek().second;
                currentIndex = currentIndex - miniIndex;
                
                q.poll();
                
                if (i == 0) startLevel = currentIndex;
                if (i == size-1) endLevel = currentIndex;
                
                if (currentNode.left != null) {
                    q.add(new Pair(currentNode.left, 2*currentIndex + 1));
                }
                if (currentNode.right != null) {
                    q.add(new Pair(currentNode.right, 2*currentIndex + 2));
                }
            }
            
            maxiWidth = Math.max(maxiWidth, endLevel - startLevel + 1);
        }
        
        return maxiWidth;
    }
}