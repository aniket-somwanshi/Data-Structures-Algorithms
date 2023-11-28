// O(N*K) O(N) K = 9 here
class Solution {
    private int count;
    public int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        int[] freq = new int[10];
        dfs(root, freq);
        return count;
    }
    
    private boolean isPalindromic(int[] freq) {
        int c = 0;
        for (int val = 1; val <= 9; val++) {
            if (freq[val]%2==1) c++;
        }
        return c <= 1;
    }
    
    private void dfs(TreeNode node, int[] freq) {
        if (node == null) return;
        
        freq[node.val]++;
        
        if (node.left == null && node.right == null) {
            count += isPalindromic(freq) ? 1 : 0;
        }
        
        dfs(node.left, freq);
        dfs(node.right, freq);
     
        // backtrack
        freq[node.val]--;
    }
}
// MLE
// class Solution {
//     private int count;
//     public int pseudoPalindromicPaths (TreeNode root) {
//         count = 0;
//         dfs(root, new ArrayList<>());
//         return count;
//     }
    
//     private boolean isPalindromic(List<Integer> list) {
//         Set<Integer> set = new HashSet<>();
//         for (int val: list) {
//             if (set.contains(val)) set.remove(val);
//             else set.add(val);
//         }
//         return set.size() <= 1;
//     }
    
//     private void dfs(TreeNode node, List<Integer> list) {
//         if (node == null) return;
        
//         list.add(node.val);
        
//         if (node.left == null && node.right == null) {
//             // System.out.println(list);
//             count += isPalindromic(list) ? 1 : 0;
//             return;
//         }
        
//         dfs(node.left, new ArrayList<>(list));
//         dfs(node.right, new ArrayList<>(list));
        
//     }
// }