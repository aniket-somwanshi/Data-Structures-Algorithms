class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        list.add(val);
        int insertedIndex = list.size()-1;
        map.put(val, insertedIndex);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int indexToRemove = map.get(val);
        
        if (indexToRemove < list.size()-1) {
            int lastNum = list.get(list.size()-1);
            list.set(indexToRemove, lastNum);
            map.put(lastNum, indexToRemove);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        return list.get((int)rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */