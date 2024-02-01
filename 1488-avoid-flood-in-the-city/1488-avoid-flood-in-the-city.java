// O(NlogN) O(N)
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        TreeSet<Integer> dryDayIndices = new TreeSet<>();
        Map<Integer, Integer> lakeOccuranceMap = new HashMap<>();
        int[] res = new int[n];
        Arrays.fill(res, 1);
        
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDayIndices.add(i);
            }
            else if (lakeOccuranceMap.containsKey(rains[i])) {
                // binary search to find if there's an dry day 
                // after the prev occurance of this lake
                Integer firstDryDayAfterLakeOccurance = dryDayIndices.higher(lakeOccuranceMap.get(rains[i]));
                if (firstDryDayAfterLakeOccurance == null) return new int[] {};
                res[firstDryDayAfterLakeOccurance] = rains[i];
                dryDayIndices.remove(firstDryDayAfterLakeOccurance);
                lakeOccuranceMap.put(rains[i], i);
                res[i] = -1;
            }
            else {
                lakeOccuranceMap.put(rains[i], i);
                res[i] = -1;
            }
        }
        
        return res;
    }
}