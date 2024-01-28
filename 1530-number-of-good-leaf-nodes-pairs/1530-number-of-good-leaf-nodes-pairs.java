// O(N) O(N-stack space)
class Solution {
    private int totalPairs = 0;
    private int distance;
    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        postOrder(root);
        return totalPairs;
    }
    
    private int[] postOrder(TreeNode node) {
        
        if (node == null) return new int[11];
        
        int[] nodesAtDistance = new int[11];
        
        if (node.left == null && node.right == null) {
            // left node, so there is one node at a distance of 1
            nodesAtDistance[1] = 1;
            return nodesAtDistance;
        } 
        
        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);
        
        // find all the valid combinations
        for (int leftDistance = 0; leftDistance <= 10; leftDistance++) {
            for (int rightDistance = 0; rightDistance <= 10; rightDistance++) {
                if (rightDistance + leftDistance <= distance) {
                    totalPairs += (left[leftDistance] * right[rightDistance]);
                }
            }
        }
        
        // while sending up, distance will increase by 1, so 
        // increment the index(distance) by 1 for all the distance
        for (int dist = 0; dist <= 9; dist++) {
            nodesAtDistance[dist+1] += left[dist];
            nodesAtDistance[dist+1] += right[dist];
        }
        
        return nodesAtDistance;
    }
}