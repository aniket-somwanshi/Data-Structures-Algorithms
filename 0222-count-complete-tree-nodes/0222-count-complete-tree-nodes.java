class Solution {
    int missing = 0;
    boolean foundLastLevel = false;
    int maxDepth = 0;
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        maxDepth = getMaxDepth(root);
        System.out.println(maxDepth);
        maxDepth++;
        getMissingNodes(root, 0);
        System.out.println(missing);
        int total = (int)Math.pow(2, maxDepth+1) - 1;
        return total - missing;
    }
    
    private void getMissingNodes(TreeNode node, int depth) {
        if (foundLastLevel) return;
        
        if (depth == maxDepth) {
            foundLastLevel = true;
            return;
        }
        
        if (node == null) return;
        
        if (node.right == null) {
            System.out.println(node.val);
            missing++;
        }
        else {
            getMissingNodes(node.right, depth + 1);
        }
        
        if (node.left == null) {
            missing++;
            System.out.println(node.val);
        }
        else {
            getMissingNodes(node.left, depth + 1);
        }
        
    }
    
    private int getMaxDepth(TreeNode node) {
        if (node.right == null) return 0;
        return 1 + getMaxDepth(node.right);
    }
    
}