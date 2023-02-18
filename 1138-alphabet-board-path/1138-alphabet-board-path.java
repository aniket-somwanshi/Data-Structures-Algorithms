// store positions of each letter on the board into a map
// for each transition that we need, compute the path
// between the 2 positions and add it to res
class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        // create the map
        Map<Character, int[]> map = new HashMap<>();
        char alphabet = 'a';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map.put(alphabet, new int[]{ i,j });
                alphabet++;
            }
        }
        map.put('z', new int[] { 5, 0 });
        
        
        
        int index = 0;
        char currentChar = 'a';
        int i = 0;
        int j = 0;
        while (index < target.length()) {
            // if we are at the same position as we want to be
            char targetChar = target.charAt(index);
            if (targetChar == currentChar) {
                res.append('!');
            }
            else {
                int targetPositionX = map.get(targetChar)[0];
                int targetPositionY = map.get(targetChar)[1];
                                              
                res.append(getPath(i, j, targetPositionX, targetPositionY));
                i = targetPositionX;
                j = targetPositionY;
                currentChar = targetChar;
                res.append('!');
            }
            index++;                                 
        }
        return res.toString();
    }
                                              
                 
    private String getPath(int i, int j, int x, int y) {
        String res = "";
        // left down up right
        if (y < j) {
            for (int t = 0; t < j-y; t++) res += "L";
        }
        if (i < x) {
            for (int t = 0; t < x-i; t++) res += "D";
        }
        if (x < i) {
            for (int t = 0; t < i-x; t++) res += "U";
        }
        if (j < y) {
            for (int t = 0; t < y-j; t++) res += "R";
        }
        
        return res;
    }
                                              
                                              
                                              
    
    <T>void f(T x) {
        System.out.println(x);
    }   
}