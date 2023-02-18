class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxiSum = Integer.MIN_VALUE;
        int maxiLevel = 1;
        
        // dfs
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int currentLevel = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            int currentLevelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = q.poll();
                currentLevelSum += currentNode.val;
                
                if (currentNode.left != null) q.add(currentNode.left); 
                if (currentNode.right != null) q.add(currentNode.right);
            }
            //System.out.println(currentLevelSum);
            if (currentLevelSum > maxiSum) {
                maxiSum = currentLevelSum;
                maxiLevel = currentLevel;
            }
            currentLevel++;
        }
        
        return maxiLevel;
    }
}