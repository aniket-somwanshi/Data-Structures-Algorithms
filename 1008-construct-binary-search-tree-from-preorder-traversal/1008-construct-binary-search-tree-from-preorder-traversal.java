// O(N) O(H) Next greater
// its preorder, so we know the root. We want to know the left subtree 
// and the right subtree. As it's a BST, left subtree is the set of nodes
// which are lesser than current node, and right subtree is nodes after that
// so for each root node, we need to find the first greater node. 
// this will be the start of it's right subtree -- this will be O(N^2)
// and we can efficiently pre-calculate next greater element for all elements in O(N)
// and then create the tree
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        
        int[] nextGreater = getNextGreater(preorder);
        
        System.out.println(Arrays.toString(nextGreater));
        return construct(nextGreater, preorder, 0, preorder.length-1);
    }
    
    private TreeNode construct(int[] ng, int[] preorder, int start, int end) {
        if (start < 0 || end >= preorder.length || start > end) return null;
        
        if (start == end) return new TreeNode(preorder[start]);
        
        // root
        TreeNode root = new TreeNode(preorder[start]);
        
        // find the start of right subtree
        int rightStart = ng[start];
        
        root.left = construct(ng, preorder, start + 1, rightStart - 1);
        root.right = construct(ng, preorder, rightStart, end);
        
        return root;
    } 
    
    private int[] getNextGreater(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Arrays.fill(res, n);
        
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && a[i] > a[s.peek()]) {
                res[s.pop()] = i;
            }
            s.push(i);
        }
        
        return res;
    }
}




// // O(N) O(H)
// // go to left, try to see if this next index node can be created here,
// // ie check if it satisfies the upper bound. 
// // Cos it has to be lesser than the current node, as it's on the left
// // Similarly, for the right, just check with same upper bound that came from parent,
// // cos right node has to be greater than node(no need to check that) and
// // it needs to be smaller than the running upper bound
// class Solution {
//     int index = 0;
//     public TreeNode bstFromPreorder(int[] preorder) {
//         if (preorder == null || preorder.length == 0) return null;
        
//         return construct(preorder, Long.MAX_VALUE);
//     }
    
//     private TreeNode construct(int[] preorder, long upperBound) {
//         if (index >= preorder.length) return null;
        
//         if (preorder[index] >= upperBound) return null;
        
//         // valid
//         TreeNode node = new TreeNode(preorder[index]);
//         index++;
        
//         node.left = construct(preorder, node.val);
        
//         node.right = construct(preorder, upperBound);
        
//         return node;
//     }  
// }