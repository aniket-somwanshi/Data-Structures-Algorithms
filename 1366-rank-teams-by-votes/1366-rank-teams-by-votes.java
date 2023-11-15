class Solution {
    int[][] map;
    public String rankTeams(String[] votes) {
        map = new int[26][26]; // [team][rank] = number of votes of this rank for this team
        for (String vote: votes) {
            for (int i = 0; i < vote.length(); i++) {
                char team = vote.charAt(i);
                map[team-'A'][i]++;
            }    
        }
        
        List<Character> str = new ArrayList<>();
        for (char c: votes[0].toCharArray()) {
            str.add(c);
        }
        
        Collections.sort(str, new TeamComparator(map));
        String res = "";
        for (char c: str) res += c;
        return res;
    }
}
class TeamComparator implements Comparator<Character> {
    private int[][] map;
    public TeamComparator(int[][] map) {
        this.map = map;
    } 
    @Override 
    public int compare(Character a, Character b) {
        int currentRank = 0;
        while (currentRank < 26) {
            if (map[a-'A'][currentRank] > map[b-'A'][currentRank]) {
                return -1;
            }
            else if (map[a-'A'][currentRank] < map[b-'A'][currentRank]) {
                return 1;
            }
            else {
                currentRank++;
            }
        }
        return a-b;
    }
}