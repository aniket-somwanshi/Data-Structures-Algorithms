class Solution {
    // O(NlogN + NlogN) O(N) .. N = number of unique cards in hand[] 
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n%groupSize != 0) return false;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // store freq
        for (int card: hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        } 
        // map is sorted on cards
        
        while (map.isEmpty() == false) {
            int iteration = groupSize;
            int target = map.firstKey();
            while (iteration-- > 0 && map.containsKey(target)) {
                // reduce freq in map
                if (map.get(target) == 1) {
                    // if none left then erase this card from map
                    map.remove(target);
                }
                else map.put(target, map.get(target)-1);
                target += 1;
            }
            // if all "groupSize" no. of consecutive cards were found,
            // then iteration will be at 0
            // if it's not at zero, it means one of the consecutive cards
            // were not found in the map
            if (iteration >= 0) return false;
        }
        return true;
    }
}