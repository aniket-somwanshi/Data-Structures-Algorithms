class Solution {
    // O(M + N) O(1) -- M = bookings.length
    // Cumulative adding
    // for any entry, add those seats to start, and subtract those seats from end+1
    // at the end move forward all indices values -- res[i] += res[i-1]
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking: bookings) {
            int start = booking[0];
            int end = booking[1];
            int seats = booking[2];
            
            res[start-1] += seats;
            if (end < n) res[end-1 + 1] -= seats;
        }
        
        for (int i = 1; i < n; i++) {
            res[i] += res[i-1];
        }
        return res;
    }
    
    
    // TLE !!  
//     public int[] corpFlightBookings(int[][] bookings, int n) {
//         int[] res = new int[n];
//         Arrays.fill(res, 0);
//         Map<Integer, List<int[]>> map = new HashMap<>();
//         // start -> (end, seats)
        
//         for (int station = 1; station <= n; station++) {
//             map.put(station, new LinkedList<>());     
//         }
        
//         for (int[] booking: bookings) {           
//             map.get(booking[0]).add(new int[] {booking[1], booking[2]});
//         }
        
//         for (int current = 1; current <= n; current++) {
//             int currentIndex = current-1;
//             List<int[]> flights = map.get(current);
//             for (int[] flight: flights) {
//                 res[currentIndex] += flight[1];
//                 // continue this flight forward
//                 if (flight[0] > current) {
//                     // add next station to map
//                     map.get(current + 1).add(new int[] {flight[0], flight[1]});
//                 }
//             }
//         }
        
//         return res;
//     }
}