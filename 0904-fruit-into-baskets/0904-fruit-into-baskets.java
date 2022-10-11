class Solution {
    // O(N) O(2)
    public int totalFruit(int[] a) {
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>(); // (fruitType, count)
        int start = 0;
        int end = 0;
        int maxi = 0;
        while (end < n) {
            map.put(a[end], map.getOrDefault(a[end], 0) + 1); // increase count of this type
            
            // if we have more than 2 fruitTypes, then
            // we are invalid so try to remove a type from left
            while (map.size() > 2) {
                // remove a[start] from map
                int count = map.get(a[start]);
                count--;
                if (count == 0) map.remove(a[start]);
                else map.put(a[start], count);
                start++;
            }
            
            
            maxi = Math.max(maxi, end - start + 1);
            end++;
        }
        return maxi;
    }
}