class Solution {
    public int minFlips(String target) {
        int countOfGroups = 0;
        
        char currentBit = '0';
        
        for (char c: target.toCharArray()) {
            if (c != currentBit) {
                countOfGroups++;
                currentBit = c;
            }
        }
        return countOfGroups;
    }
}