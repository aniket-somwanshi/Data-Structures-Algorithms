class Entry {
    int timestamp;
    String val;
    public Entry(int timestamp, String val) {
        this.timestamp = timestamp;
        this.val = val;
    }
}

class TimeMap {
    private Map<String, List<Entry>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    // O(1)
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key) == false) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Entry(timestamp, value));
    }
    
    // O(logN) O(N)
    public String get(String key, int timestamp) {
        if (map.containsKey(key) == false) return "";
        List<Entry> a = map.get(key);
        return binarySearch(a, timestamp);
    }
    
    private String binarySearch(List<Entry> a, int targetTimestamp) {
        int high = a.size()-1;
        int low = 0;
        String res = "";
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (a.get(mid).timestamp <= targetTimestamp) {
                res = a.get(mid).val;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return res;
    } 
    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */