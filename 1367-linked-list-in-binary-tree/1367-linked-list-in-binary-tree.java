class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) {
            return false;
        }
        
        if(head.val == root.val) {
            ListNode thead = head;
            boolean ans = check(thead, root);
            if(ans) {
                return true;
            }
        }
        
        boolean left = isSubPath(head, root.left);
        if(left) {
            return true;
        }
        
        boolean right = isSubPath(head, root.right);
        if(right) {
            return true;
        }
        
        return false;
    }
    
    public boolean check(ListNode head, TreeNode root) {
        if(head == null) {
            return true;
        }
        
        if(root == null || head.val != root.val) {
            return false;
        }
        
        boolean left = check(head.next, root.left);
        if(left) {
            return true;
        }
        
        boolean right = check(head.next, root.right);
        if(right) {
            return true;
        }
        
        return false;
    }
}