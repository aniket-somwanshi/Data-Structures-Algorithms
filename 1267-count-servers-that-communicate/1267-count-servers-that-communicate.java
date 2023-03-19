// O(N*M + N*M) O(M+N) 
// count the number of servers in every row and in every column
// now go over every server and see if 
// that server is the only one in it's row and col
// if so, that's a isolated server so we can't count that
// rest all we can count
class Solution {
    public int countServers(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        
        int totalServers = 0;
        HashMap<Integer, Integer> rowServers = new HashMap<>(); // [row, no.Of servers in this row]
        HashMap<Integer, Integer> colServers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    // increment number of servers in this row
                    rowServers.put(i, rowServers.getOrDefault(i, 0) + 1);
                    // and similar for this col
                    colServers.put(j, colServers.getOrDefault(j, 0) + 1);
                    
                    totalServers++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    // if this row and this col contains only single server, ie this one,
                    // it's an isolated server, so it's not a connected server
                    // so reduce the number of connected servers
                    if (rowServers.get(i) == 1 && colServers.get(j) == 1) totalServers--;
                }
            }
        }
        
        return totalServers;
    }
}