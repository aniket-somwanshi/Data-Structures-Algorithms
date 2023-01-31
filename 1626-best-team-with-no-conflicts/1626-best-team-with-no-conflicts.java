class Solution {
    // O(N^2) O(N)
    /*
    Sort according to desc ages, if equal by scores desc
    (6,2) (4,2) (5,1) (5,1)
      -     -     -     5
    For (5,1) we check all lesser ages
    and if the score of current is greater, 
    only then we can add current, to that index's collection
    (As current is equal or older than next 'j's, 
    so score must be higher)
    if no such j is found, ans is current score
    (6,2) (4,2) (5,1) (5,1)
      -     -     10     5
    
    (6,2) (4,2) (5,1) (5,1)
      -     4     10     5 
    
              (6,2) (4,2) (5,1) (5,1)
    (6+10) or (6+4)   4     10     5
    
    */
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        
        // sort desc
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(scores[i], ages[i]);
        }
        Arrays.sort(players);
        
        int maxTotalScore = 0;
        
        if (n == 1) return players[0].score;
        int[] maxScoreStartingFrom = new int[n];
        maxScoreStartingFrom[n-1] = players[n-1].score;
        for (int i = n-2; i >= 0; i--) {
            maxScoreStartingFrom[i] = players[i].score;
            for (int j = i+1; j < n; j++) {
                if (players[j].age == players[i].age || players[j].score <= players[i].score) {
                    maxScoreStartingFrom[i] = Math.max(maxScoreStartingFrom[i],
                                                      players[i].score + maxScoreStartingFrom[j]);
                }
            }
            // update global max
            maxTotalScore = Math.max(maxTotalScore, maxScoreStartingFrom[i]);
        }
        return maxTotalScore;
    }
    
    class Player implements Comparable<Player> {
        int score;
        int age;
        public Player(int score, int age) {
            this.score = score;
            this.age = age;
        }
        
        @Override
        public int compareTo(Player a) {
            if (this.age > a.age) return -1;
            else if (this.age < a.age) return 1;
            else {
                if (this.score > a.score) return -1;
                else return 1;
            }
        }
        
    }
}








