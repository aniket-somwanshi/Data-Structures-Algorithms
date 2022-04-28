class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
                TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(newInterval[0], 1);
        map.put(newInterval[1], map.getOrDefault(newInterval[1], 0) - 1);
        
        for(int[] i : intervals) {
            int existing = map.getOrDefault(i[0], 0);
            map.put(i[0], existing + 1);
            
            existing = map.getOrDefault(i[1], 0);
            map.put(i[1], existing - 1);
            
        }
        
        List<int[]> list = new ArrayList<>();
        int c = 0;
        int start = -1;
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (start == -1) {
                start = key;
            }
            c += value;
            if (c == 0) {
                list.add(new int[]{start, key});
                start = -1;
            }
        }
        
        int[][] result = new int[list.size()][2];
        for(int j = 0; j < list.size(); j++)
            result[j] = list.get(j);
        
        return result;
    }
}