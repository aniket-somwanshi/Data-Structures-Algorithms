// O(N + 8*8) O(N)
class Solution {
    private int[][] dirs = new int[][] {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}
    };
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // start point
        int r = king[0];
        int c = king[1];
        
        // insert all queens into map
        Set<Integer> set = new HashSet<>(); // all queen positions in 1-Dimension 
        for (int[] queen: queens) set.add(get1DPosition(queen[0], queen[1]));
        
        // result
        List<List<Integer>> res = new LinkedList<>();
        
        // go in all 8 directions and when we find the first closest queen
        // return and add to res
        for (int[] dir: dirs) {
            int newR = r;
            int newC = c;
            
            while (newR >= 0 && newC >= 0 && newR < 8 && newC < 8) {
                if (set.contains(get1DPosition(newR, newC))) {
                    List<Integer> attacker = new ArrayList<>();
                    attacker.add(newR);
                    attacker.add(newC);
                    res.add(attacker);
                    break;
                }
                else {
                    newR = newR + dir[0];
                    newC = newC + dir[1];
                }
            }
        }
        
        return res;
    }
    
    private int get1DPosition(int r, int c) {
        return 8*r + c;
    }
    
    private int[] get2DPosition(int pos) {
        int r = pos/8;
        int c = pos%8;
        return new int[] {r,c};
    }
}