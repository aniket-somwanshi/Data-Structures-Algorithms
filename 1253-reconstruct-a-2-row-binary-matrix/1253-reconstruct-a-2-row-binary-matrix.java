class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int i = 0; i < colsum.length; i++) {
            res.get(0).add(0);
            res.get(1).add(0);
        }
        
        List<List<Integer>> empty = new ArrayList<>();
        
        // if colsum is 0 => both 0
        // if colsum is 2 => both 1
        // if colsum is 1 => give 1 to the bigger between upper and lower
        // and decrement upper or lower by 1
        // if at any point upper or lower goes negative return empty
        // at the end if upper and lower are not zero means they are not satisfied
        // so return empty, else return res
        
        for (int i = 0; i < colsum.length; i++) {
            // invalidity check
            if (lower < 0 || upper < 0) return empty;
            if (colsum[i] == 2) {
                res.get(0).set(i, 1);
                res.get(1).set(i, 1);
                upper--;
                lower--;
            }
            else if (colsum[i] == 1) {
                if (upper > lower) {
                    res.get(0).set(i, 1);
                    upper--;
                }
                else {
                    res.get(1).set(i, 1);
                    lower--;
                }
            }
        }
        
        return (lower < 0 || upper < 0 || lower != 0 || upper != 0) ? empty : res;
    }
}