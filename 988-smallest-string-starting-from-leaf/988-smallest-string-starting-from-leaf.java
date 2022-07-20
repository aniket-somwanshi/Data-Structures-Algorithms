class Solution {
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char)('a' + node.val));

        if (node.left == null && node.right == null) {
            sb.reverse();
            String S = sb.toString();
            sb.reverse();

            if (S.compareTo(ans) < 0)
                ans = S;
        }

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}

// class Solution {
        // failed approach
//     private char[] ascii = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
//     public String smallestFromLeaf(TreeNode root) {
//         return getSmallerString(root);
//     }
    
//     private String getSmallerString(TreeNode node) {
//         if (node == null) return "";
//         String leftString =  getSmallerString(node.left);
//         String rightString =  getSmallerString(node.right);

//         char currentChar = ascii[node.val];
//         // System.out.println(ascii[node.val]);
        
//         if (leftString.equals("")) return rightString + currentChar;
//         if (rightString.equals("")) return leftString + currentChar;
        
//         leftString += currentChar;
//         rightString += currentChar;
        
//         System.out.println(leftString + " " +rightString);
            
//         for (int i = 0; i < leftString.length() || i < rightString.length(); i++) {
//             if (i >= leftString.length()) return leftString;
//             if (i >= rightString.length()) return rightString;
            
//             if (leftString.charAt(i) == rightString.charAt(i)) continue;
            
//             if (leftString.charAt(i) < rightString.charAt(i)) return leftString;
//             else return rightString;   
//         }
//         return leftString;
//     }
// }