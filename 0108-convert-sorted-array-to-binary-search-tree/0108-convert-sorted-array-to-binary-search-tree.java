/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// O(N) O(logN)
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedBST(0, nums.length-1, nums);
    }
    
    private TreeNode buildBalancedBST(int l, int r, int[] nums) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);
        
        int mid = l + (r - l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = buildBalancedBST(l, mid-1, nums);
        root.right = buildBalancedBST(mid+1, r, nums);
        
        return root;
    }
}