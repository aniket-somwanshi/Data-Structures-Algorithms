class Solution {
    // O(6*N) O(1)
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int miniSwaps = Integer.MAX_VALUE;
        
        for (int commonDomino = 1; commonDomino <= 6; commonDomino++) {            
            int i = 0;
            int topSwapsNeeded = 0;
            int bottomSwapsNeeded = 0;
            for (; i < n; i++) {
                if (tops[i] != commonDomino && bottoms[i] != commonDomino) {
                    break;
                }
                else if (tops[i] != commonDomino) {
                    topSwapsNeeded++;
                }
                else if (bottoms[i] != commonDomino) {
                    bottomSwapsNeeded++;
                }
            }
            if (i == n) {
                System.out.println(commonDomino + " " + topSwapsNeeded);
                miniSwaps = Math.min(miniSwaps, Math.min(topSwapsNeeded, bottomSwapsNeeded));
            }
        }
        return miniSwaps == Integer.MAX_VALUE ? -1 : miniSwaps;
    }
}