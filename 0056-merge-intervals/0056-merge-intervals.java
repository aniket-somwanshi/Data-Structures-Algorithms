// O(NlogN + N) O(N (sorting))
class Solution {
    public int[][] merge(int[][] a) {
        int n = a.length;
        
        Arrays.sort(a, (a1, b1) -> a1[0] - b1[0]);
        
        List<int[]> res = new ArrayList<>();
        res.add(new int[] {a[0][0], a[0][1]});
        
        for (int i = 1; i < n; i++) {
            if (res.get(res.size()-1)[1] < a[i][0]) {
                res.add(new int[] {a[i][0], a[i][1]});
            }
            else {
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], a[i][1]);
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}