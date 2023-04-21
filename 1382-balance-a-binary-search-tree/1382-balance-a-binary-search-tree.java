class Solution {
    List<Integer> list; 
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        int[] a = new int[list.size()];
        int i=0;
        for (int num: list) {a[i++] = num;}
        
        return f(a, 0, a.length-1);
    }
    
    private TreeNode f(int[] a, int i, int j) {
        if (i > j) return null;
        if (i == j) return new TreeNode(a[i]);
        
        int mid = i+(j-i)/2;
        TreeNode root = new TreeNode(a[mid]);
        root.left = f(a, i, mid-1);
        root.right = f(a, mid+1, j);
        
        return root;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
    
    
}