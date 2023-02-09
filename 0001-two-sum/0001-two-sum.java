class Solution {
    public int[] twoSum(int[] a, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(target - a[i])) {
                
                res[0] = map.get(target - a[i]);
                res[1] = i;
                return res;
            }
            else map.put(a[i], i);
        }
        return res;
    }
}