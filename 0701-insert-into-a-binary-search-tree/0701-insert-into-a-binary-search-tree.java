// O(H) O(1) --iterative
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        TreeNode node = root;
        while (node != null) {
            if (node.val > val) {
                // go left
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                }
                node = node.left;
            }
            else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }
                node = node.right;
            }
        }
        return root;
    }
}

// O(H) O(H) --recursive
// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         if (root == null) return new TreeNode(val);
//         dfs(root, val);
//     		return root;
// }
// 	private void dfs(TreeNode node, int val) {
// 	if (node == null) return;
// 	if (node.val > val) {
// 	// go left
// 	if (node.left == null) {
// 	node.left = new TreeNode(val);
// 	return;
// }
// dfs(node.left, val);
// }
// else {
// 	if (node.right == null) {
// 	node.right = new TreeNode(val);
// 	return;
// }
// dfs(node.right, val);
// }
// }
// }


