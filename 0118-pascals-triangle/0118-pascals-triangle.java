class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) res.add(new ArrayList<>());
        
        res.get(0).add(1);
        if (numRows == 1) return res;
        
        res.get(1).add(1);
        res.get(1).add(1);
        if (numRows == 2) return res;
        
        for (int row = 2; row < numRows; row++) {
            // first element is always 1
            res.get(row).add(1);
            
            // add all the intermediate elements
            // they are indices [1, row-1]
            for (int i = 1; i <= row-1; i++) {
                res.get(row).add(res.get(row-1).get(i)+res.get(row-1).get(i-1));
            }
            
            // last element is always 1
            res.get(row).add(1);
        }
        
        return res;
    }
}