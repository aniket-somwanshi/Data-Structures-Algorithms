class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            while (size-- > 0) {
                TreeNode current = q.poll();
                currentLevel.add(current.val);
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            res += cost(currentLevel);
        }
        
        return res;
    }
    
    private int cost(List<Integer> list) {
        int n = list.size();
        int[] a = new int[n];
        int[] sorted = new int[n];
        
        for (int i = 0; i < n; i++)  {
            a[i] = list.get(i);
            sorted[i] = a[i];
        }
        
        Arrays.sort(sorted);
        
        Map<Integer, Integer> correctIndex = new HashMap<>();
        for (int i = 0; i < n; i++) correctIndex.put(sorted[i], i);
        int cost = 0;
        int i = 0;
        while (i < n) {
            int crr =correctIndex.get(a[i]);
            if (i !=crr) {
                cost++;
                // swap correctIndex and i
                int temp = a[crr];
                a[crr] = a[i];
                a[i] = temp;
            }
            else i++;
        }
        
        return cost;
    }
    
    private int cmp(int x, int y, int[] a) {
        return a[x]-a[y];
    }
}