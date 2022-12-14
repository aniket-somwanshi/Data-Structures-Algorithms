class rowPair {
    TreeNode node;
    int row;
    public rowPair(TreeNode n, int r) {
        node = n;
        row = r;
    }
}

class colPair {
    TreeNode node;
    int col;
    public colPair(TreeNode n, int c) {
        node = n;
        col = c;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        // keep track of the smallest column encountered
        int smallestColumn = Integer.MAX_VALUE;
        
        // Map
        // column -> [(node1,row1), (node2, row1), (node3, row2)]
        Map<Integer, List<rowPair>> map = new HashMap<>(); 
        
        
        /// BFS
        Queue<colPair> q = new LinkedList<>();
        
        q.add(new colPair(root, 0));
        
        int currentRow = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) { // todo while loop
                colPair current = q.poll();
                
                // keep track of the smallest col encountered
                smallestColumn = Math.min(smallestColumn, current.col);
                
                // add current to it's correct row position in map
                if (!map.containsKey(current.col)) {
                    map.put(current.col, new ArrayList<>());
                }
                
                List<rowPair> list = map.get(current.col);
                // if the last value in this col has the same row as current col
                // make sure the two nodes are sorted
                if (!list.isEmpty()) {
                    // if it's not in correct order
                    int j = list.size()-1;
                    int numbersToSort = 0;
                    while (j >= 0 && list.get(j).row == currentRow && list.get(j).node.val > current.node.val) {
                        j--;
                        numbersToSort++;
                    }
                    list.add(new rowPair(current.node, currentRow));
                    Collections.sort(list.subList(j+1,list.size()), ((a,b)->a.node.val-b.node.val));
                }
                else {
                    // simply add it
                    list.add(new rowPair(current.node, currentRow));
                }
                
                // process it's left and right child next
                if (current.node.left != null) q.add(new colPair(current.node.left, current.col-1));
                if (current.node.right != null) q.add(new colPair(current.node.right, current.col+1));
            }
            currentRow++;
        }
        
        
        // starting from colPair, add all the nodes in the map into our res list, 
        // until we reach our last column
        
        int columnIndex = smallestColumn;
        while (map.containsKey(columnIndex)) {
            res.add(new ArrayList<>());
            List<Integer> currentList = res.get(res.size()-1);
            for (rowPair rp: map.get(columnIndex)) {
                currentList.add(rp.node.val);
            } 
            columnIndex++;
        }
        
        return res;
    }
}