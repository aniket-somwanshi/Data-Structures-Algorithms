class Checkin {
    String station;
    int time;
    public Checkin(String s, int t) {
        station = s;
        time = t;
    }
}
class UndergroundSystem {
    Map<Integer, Checkin> checkinMap;
    Map<String, int[]> averageTimeMap;
    public UndergroundSystem() {
        checkinMap = new HashMap<>();
        averageTimeMap = new HashMap<>();
    }
    
    // put entry in map of <user, {station, time}>
    public void checkIn(int id, String stationName, int t) {
        checkinMap.put(id, new Checkin(stationName, t));
    }
    
    // put entry in map of <station1-station2, {sum, count}>
    // remove entry from map of users
    public void checkOut(int id, String stationName, int t) {
        Checkin checkin = checkinMap.get(id);
        checkinMap.remove(id);
        int timeTaken = t - checkin.time;
        String fromStation = checkin.station;
        String toStation = stationName;
        String stationPair = fromStation + "-" + toStation;
        
        if (!averageTimeMap.containsKey(stationPair)) {
            averageTimeMap.put(stationPair, new int[] {0, 0});
        }
        
        int[] c = averageTimeMap.get(stationPair);
        c[0] += timeTaken;
        c[1] += 1;
    }
    
    // return sum/count
    public double getAverageTime(String startStation, String endStation) {
        String stationPair = startStation + "-" + endStation;
        int[] c = averageTimeMap.get(stationPair);
        return (double)(1D * (double)c[0] / (double)c[1]);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */