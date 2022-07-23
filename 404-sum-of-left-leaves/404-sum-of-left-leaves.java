class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        check(root,false);
        return sum;
    }
    
    private void check(TreeNode root, boolean isLeft){
        if(root == null) return;
        if(root.left == null && root.right == null && isLeft) sum+=root.val;
        check(root.left,true);
        check(root.right,false);
    }
}