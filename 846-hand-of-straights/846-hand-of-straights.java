import java.util.SortedMap;


class Solution {
    // O(N logN) O(N)
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        
        // if n is not a multiple of groupSize its never possible
        if (n % groupSize != 0) return false;
        
        SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        // populate map
        for (int num: hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // for every groupSize, try to find consecutive numbers in map
        // if it doesn't exist, return false
        int numberOfGroups = n/groupSize;
        while (numberOfGroups-- > 0) {
            int numberOfGroupElements = groupSize;
            int current = map.firstKey();
            while (numberOfGroupElements-- > 0) {
                if (map.containsKey(current)) {
                    // if it was not the last one, reduce the count
                    if (map.get(current) > 1) {
                        map.put(current, map.get(current) - 1);
                    }
                    // else there are no more keys so erase it
                    else {
                        map.remove(current);
                    }
                    current = current + 1;
                }
                else return false;
            }
        }
        
        return true;
    }
}