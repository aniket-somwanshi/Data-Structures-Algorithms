class Solution {
    int ans=0;
    public void help(TreeNode root,String curr){
        if(root.left==null&&root.right==null){
            curr+=Integer.toString(root.val);
            ans+=Integer.parseInt(curr);
            return;
        }
        curr+=Integer.toString(root.val);
        if(root.left!=null)help(root.left,curr);
        if(root.right!=null)help(root.right,curr);
    }
    public int sumNumbers(TreeNode root) {
        help(root,"0");
        return ans;
    }
}