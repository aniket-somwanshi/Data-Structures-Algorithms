class Solution {
    // O(NlogN + N) O(logN -- sorting) 
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        
        int getScoreIndex = 0;
        int getPowerIndex = n-1;
        
        int currentScore = 0;
        int maxiScore = 0;
        while (getScoreIndex <= getPowerIndex) {
            if (power >= tokens[getScoreIndex]) {
                currentScore++;
                power -= tokens[getScoreIndex];
                getScoreIndex++;
            }
            else if (currentScore >= 1){
                currentScore--;
                power += tokens[getPowerIndex];
                getPowerIndex--;
            }
            else return maxiScore;
            maxiScore = Math.max(maxiScore, currentScore);
        }
        return maxiScore;
    }
}