class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;
        
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int i = 0;
        int j = 0;
        
        int matches = 0;
        
        while (i < n && j < m) {
            if (players[i] <= trainers[j]) {
                matches++;
                i++;
                j++;
            }
            else {
                j++;
            }
        }
            
        return matches;
    }
}